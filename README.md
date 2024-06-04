# experiment-8 (MiniJava)
It's the eighth experiment of Software Engineering Lab course in Spring 2024 at Sharif University of Technology.

Mini-Java is a subset of Java. MiniJava compiler implement a compiler for the Mini-java
programming language.

# Rules
```
Goal --> Source EOF
Source --> ClassDeclarations MainClass
MainClass --> class Identifier { public static void main() { VarDeclarations Statements}}
ClassDeclarations --> ClassDeclaration ClassDeclarations | lambda
ClassDeclaration --> class Identifier Extension { FieldDeclarations MethodDeclarations }
Extension --> extends Identifier | lambda
FieldDeclarations --> FieldDeclaration FieldDeclarations | lambda
FieldDeclaration --> static Type Identifier ;
VarDeclarations --> VarDeclaration VarDeclarations | lambda
VarDeclaration --> Type Identifier ;
MethodDeclarations --> MethodDeclaration MethodDeclarations | lambda
MethodDeclaration --> public static Type Identifier ( Parameters ) { VarDeclarations Statements return GenExpression ; }
Parameters --> Type Identifier Parameter | lambda
Parameter --> , Type Identifier Parameter | lambda
Type --> boolean | int
Statements --> Statements Statement | lambda
Statement --> { Statements } | if ( GenExpression ) Statement else Statement | while ( GenExpression ) Statement | System.out.println ( GenExpression ) ; | Identifier = GenExpression ;
GenExpression --> Expression | RelExpression
Expression --> Expression + Term | Expression - Term | Term
Term --> Term * Factor | Factor
Factor --> ( Expression ) | Identifier | Identifier . Identifier | Identifier . Identifier ( Arguments ) | true | false | Integer
RelExpression --> RelExpression && RelTerm | RelTerm
RelTerm --> Expression == Expression | Expression < Expression
Arguments --> GenExpression Argument | lambda
Argument --> , GenExpression Argument | lambda
Identifier --> <IDENTIFIER_LITERAL>
Integer --> <INTEGER_LITERAL>
```

الگوی Facade برای ارائه یک رابط ساده به یک زیرسیستم پیچیده استفاده می شود. در کد ارائه شده، کلاس «Parser» به عنوان یک Facade عمل می کند و تعاملات با زیرسیستم های درگیر در تجزیه(parse) و تولید کد(code generation) را ساده می کند.

در اینجا دو مورد وجود دارد که الگوی Facade در کد کلاس Parser اعمال می شود:

1. **تعامل با تحلیلگر واژگانی(Lexical Analyzer)**:
 - در کلاس «Parser»، زیر سیستم تحلیل واژگانی از طریق نمونه(instance) «lexicalAnalyzer» قابل دسترسی است. کلاس «Parser» یک رابط ساده برای دریافت نشانه(token) بعدی از ورودی با استفاده از تابع «()lexicalAnalyzer.getNextToken» ارائه می‌کند. جزئیات نحوه تجزیه و تحلیل و تولید توکن ها ازکلاینت پنهان است (در این مورد، خود کلاس «Parser»). کلاس «lexicalAnalyzer» مستقیماً با استفاده از کلاس «Parser» در معرض کلاینت قرار نمی گیرد.

 ``java
 lexicalAnalyzer = new lexicalAnalyzer(sc);
 Token lookAhead = lexicalAnalyzer.getNextToken();
 ```

2. **تعامل با مولد کد(Code Generator)**:
 - به طور مشابه، زیرسیستم تولید کد از طریق نمونه «CodeGenerator» قابل دسترسی است. کلاس «Parser» یک رابط ساده برای انجام اقدامات معنایی(semantics) از طریق تابع «cg.semanticFunction(rule.semanticAction, lookAhead)» ارائه می‌کند. پیچیدگی نحوه تولید کد بر اساس اقدامات معنایی در کلاس 'CodeGenerator' محصور شده است و کلاس 'Parser' به عنوان نمای(facade) برای این زیرسیستم عمل می کند.

 ``java
 cg = new CodeGenerator();
 ...
 try {
 cg.semanticFunction(rule.semanticAction، lookAhead);
 } catch (Exception e) {
 Log.print ("Code Generator Error");
 }
 ```
