grammar ActorLang;

@header {
package org.actorlang.antlr.gen;
}

WS: [ \r\t\n]+ -> channel(HIDDEN);

COMMENT: '/*' .*? '*/' -> channel(HIDDEN);

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
For: 'for';
In: 'in';
Put: 'put';
Fun: 'fun';
Return: 'return';
Call: 'call';

Identifier: [a-zA-Z_][a-zA-Z0-9_]*;

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
    | funCall
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
    | ifBehaviorStmt
    | forStmt
    | putStmt
    | callStmt
;

displayStmt: Display expr;

putStmt: Put expr;

becomeStmt: Become parameterizedBehavior;

sendStmt: Send LBracket (expr (Comma expr)*)? RBracket To identifier;

assignStmt: identifier Assign expr;

ifBehaviorStmt:
      If LParen expr RParen
      LCurly
        (thenStmts+=behaviorStmt (Semi thenStmts+=behaviorStmt)* Semi?)?
      RCurly
      (Else
      LCurly
        (elseStmts+=behaviorStmt (Semi elseStmts+=behaviorStmt)* Semi?)?
      RCurly)?
;

ifFunStmt:
      If LParen expr RParen
      LCurly
        (thenStmts+=funStmt (Semi thenStmts+=funStmt)* Semi?)?
      RCurly
      (Else
      LCurly
        (elseStmts+=funStmt (Semi elseStmts+=funStmt)* Semi?)?
      RCurly)?
;

forStmt:
      For LParen identifier In begin=atom '..' end=atom RParen
      LCurly
        (behaviorStmt (Semi behaviorStmt)* Semi?)?
      RCurly
;

funDef:
      Fun name=identifier LParen (args+=identifier (Comma args+=identifier)*)? RParen
      Assign (expr | funStmt | (LCurly (funStmt (Semi funStmt)* Semi?)? RCurly))
;

funStmt:
      displayStmt
    | putStmt
    | sendStmt
    | assignStmt
    | ifFunStmt
    | forStmt
    | returnStmt
    | callStmt
;

returnStmt: Return expr;

funCall: identifier LParen (expr (Comma expr)*)? RParen;

callStmt: Call funCall;

createExpr: Create parameterizedBehavior;

parameterizedBehavior: identifier LParen (expr (Comma expr)*)? RParen;

toplevelStmt:
      behavior
    | funDef
    | displayStmt
    | sendStmt
    | assignStmt
    | forStmt
    | putStmt
    | callStmt
;

root: (toplevelStmt (Semi toplevelStmt)* Semi?)? EOF;
