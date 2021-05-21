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

compOp:
      Eq
    | Neq
    | Lower
    | Leq
    | Greater
    | Geq
;

expr: orExpr;

orExpr: andExpr (Or andExpr)* ;

andExpr: eqExpr (And eqExpr)* ;

eqExpr: compExpr (Eq compExpr)? ;

compExpr: arithExpr (compOp arithExpr)? ;

arithExpr: termExpr ((Plus | Minus) termExpr)* ;

termExpr: factorExpr (Star factorExpr)* ;

factorExpr: moduloExpr (Slash moduloExpr)* ;

moduloExpr: unary (Percent unary)? ;

unaryMinus: Minus atom;

unaryNot: Not atom;

unary:
      unaryMinus
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

parenExpression: '(' expr ')';

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
    | createStmt
;

displayStmt: Display expr;

becomeStmt: Become parameterizedBehavior;

sendStmt: Send LBracket (expr (Comma expr)*)? RBracket To identifier;

createStmt: identifier Assign Create parameterizedBehavior;

parameterizedBehavior: identifier LParen (expr (Comma expr)*)? RParen;

toplevelStmt:
      behavior
;

root: (toplevelStmt (Semi toplevelStmt)* Semi?)? EOF;
