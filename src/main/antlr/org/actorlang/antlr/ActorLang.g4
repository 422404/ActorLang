grammar ActorLang;

@header {
    package org.actorlang.antlr;
}

WS: [ \r\t\n]+ -> channel(HIDDEN);

fragment Digit: [0-9] ;
IntegerLiteral: Digit+ ;
StringLiteral: '"' (('\\' .) | ~'"')* '"';
True: 'true';
False: 'false';
Self: 'self';

Create: 'create';
Become: 'become';
Display: 'display';
Send: 'send';
To: 'to';
If: 'if';
Else: 'else';

Identifier: [a-zA-Z][a-zA-Z0-9_]*;

LParen: '(';
RParen: ')';
LBracket: '[';
RBracket: ']';
LCurly: '{';
RCurly: '}';
Comma: ',';
Semi: ';';

Assign: '=' | '←';

Eq: '==';
Neq: '!=' | '≠';
Lower: '<';
Leq: '<=' | '≤';
Greater: '>';
Geq: '>=' | '≥';

And: '&&';
Or: '||';

Plus: '+';
Minus: '-';
Star: '*';
Slash: '/';
Percent: '%';

Not: '!' | '¬';

eqOp:
      Eq
    | Neq
;

compOp:
      Lower
    | Leq
    | Greater
    | Geq
;

arithOp:
      Plus
    | Minus
;

expr:
      orExpr
    | createExpr;

orExpr: andExpr (Or orExpr)?;

andExpr: eqExpr (And andExpr)?;

eqExpr: compExpr (eqOp compExpr)?;

compExpr: arithExpr (compOp arithExpr)?;

arithExpr: termExpr (arithOp arithExpr)?;

termExpr: factorExpr (Star termExpr)?;

factorExpr: moduloExpr (Slash factorExpr)?;

moduloExpr: unary (Percent unary)?;

unaryPlus: Plus atom;

unaryMinus: Minus atom;

unaryNot: Not atom;

unary:
      unaryPlus
    | unaryMinus
    | unaryNot
    | atom
;

atom:
      literal
    | identifier
    | parenExpression
;

literal:
      IntegerLiteral
    | StringLiteral
    | True
    | False
    | Self
;

identifier: Identifier;

parenExpression: LParen expr RParen;

behavior:
    identifier behaviorState behaviorMessagePattern Assign
    (behaviorStmt | (LCurly (behaviorStmt (Semi behaviorStmt)* Semi?)? RCurly));

behaviorState: LParen (identifier (Comma identifier)*)? RParen;

behaviorMessagePattern:
    LBracket (behaviorMessagePatternItem (Comma behaviorMessagePatternItem)*)? RBracket;

behaviorMessagePatternItem:
      identifier
    | literal
;

behaviorStmt:
      displayStmt
    | becomeStmt
    | sendStmt
    | assignStmt
    | ifStmt
;

displayStmt: Display expr;

becomeStmt: Become parameterizedBehavior;

sendStmt: Send LBracket (expr (Comma expr)*)? RBracket To identifier;

assignStmt: identifier Assign expr;

ifStmt:
      If LParen expr RParen
      LCurly
        (thenStmts+=behaviorStmt (Semi thenStmts+=behaviorStmt)* Semi?)?
      RCurly
      (Else
      LCurly
        (elseStmts+=behaviorStmt (Semi elseStmts+=behaviorStmt)* Semi?)?
      RCurly)?
;

createExpr: Create parameterizedBehavior;

parameterizedBehavior: identifier LParen (expr (Comma expr)*)? RParen;

toplevelStmt:
      behavior
    | displayStmt
    | sendStmt
    | assignStmt
;

root: (toplevelStmt (Semi toplevelStmt)* Semi?)? EOF;
