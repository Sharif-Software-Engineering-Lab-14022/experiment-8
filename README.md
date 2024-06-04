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
# پرسش‌ها
## سوال 1
**کد تمیز**: کدی که خوانا، قابل فهم، قابل نگهداری و توسعه باشد و توسط دیگر توسعه‌دهندگان به راحتی درک شود.

**بدهی فنی**: مشکلات و کمبودهای فنی در کد که به دلیل تصمیمات عجولانه یا روش‌های غیراستاندارد ایجاد شده و نیازمند اصلاح و بهبود در آینده است.

**بوی بد**: نشانه‌های آشکار در کد که به وجود مشکلات احتمالی، کیفیت پایین یا نیاز به بازنگری و اصلاح اشاره می‌کنند.

## سوال 2
1. **Long Method (متد طولانی)**:
روشی که بیش از حد طولانی است و چندین وظیفه را انجام می‌دهد، که باعث می‌شود کد سخت‌تر خوانده و نگهداری شود. چنین روشی باید به متدهای کوچکتر و مشخص‌تر تقسیم شود.

2. **Large Class (کلاس بزرگ)**:
کلاسی که وظایف زیادی دارد و بیش از حد پیچیده است. این کلاس‌ها معمولاً باید به چند کلاس کوچکتر که هر کدام مسئولیت‌های مشخص‌تری دارند تقسیم شوند.

3. **Primitive Obsession (وسواس استفاده از انواع داده اولیه)**:
استفاده بیش از حد از انواع داده اولیه (مثل اعداد و رشته‌ها) به جای استفاده از انواع داده پیچیده‌تر یا اشیاء خاص دامنه، که باعث می‌شود کد کمتر گویا و انعطاف‌پذیر باشد.

4. **Long Parameter List (لیست پارامتر طولانی)**:
متدهایی که تعداد زیادی پارامتر دریافت می‌کنند، که می‌تواند خوانایی کد را کاهش دهد و استفاده از متد را پیچیده کند. بهتر است این پارامترها در قالب اشیاء یا ساختارهای داده مناسب تجمیع شوند.

5.**Data Clumps (تجمع داده‌ها)**:
گروه‌هایی از داده‌ها که همیشه با هم استفاده می‌شوند و به صورت مکرر در سراسر کد تکرار می‌شوند. این داده‌ها باید در قالب کلاس‌ها یا اشیاء مناسب بسته‌بندی شوند تا کد خواناتر و قابل نگهداری‌تر شود.

## سوال 3
**Lazy Class** در دسته‌بندی **Large Class (کلاس بزرگ)** قرار می‌گیرد، زیرا این بوی بد معمولاً به دلیل کلاس‌هایی ایجاد می‌شود که وظایف کافی برای توجیه وجود خود ندارند و عملاً بی‌فایده هستند.

برای برطرف کردن این بو، معمولاً از بازآرایی‌های زیر استفاده می‌شود:
1. **Inline Class**: اگر یک کلاس تنها وظایف کوچکی دارد، می‌توان آن را با یک کلاس دیگر که از آن استفاده می‌کند ترکیب کرد تا کد ساده‌تر و تمیزتر شود.
2. **Collapse Hierarchy**: اگر یک کلاس به صورت غیر ضروری از یک کلاس پایه ارث‌بری کرده و هیچ ویژگی خاصی به ارث نمی‌برد، می‌توان سلسله مراتب کلاس‌ها را ساده‌تر کرد.

در برخی موارد، می‌توان **Lazy Class** را نادیده گرفت:
1. **زمانی که انتظار می‌رود کلاس در آینده توسعه یابد**: اگر برنامه‌ای برای افزودن قابلیت‌ها و وظایف جدید به این کلاس وجود دارد، می‌توان وجود کلاس را موجه دانست.
2. **در مواردی که کلاس برای یکپارچگی معماری نرم‌افزار لازم است**: اگر وجود کلاس برای حفظ ساختار یا الگوی طراحی خاصی ضروری است، می‌توان وجود آن را توجیه کرد حتی اگر فعلاً وظایف کمی داشته باشد.

## سوال 4
در اینجا ده «بوی بد» شناسایی شده در کد جاوا (main.java) ارائه شده است:

1. **Excessive Imports**:
 - کد بسیاری از بسته ها را وارد می کند، از جمله برخی از آنها که استفاده نمی شوند، مانند `javax.xml.parsers.*` و `javax.xml.transform.*`.

2. **Large Class**:
 - کلاس `Main` بسیار بزرگ است و دارای چندین مسئولیت از جمله پردازش فایل، مدیریت رابط کاربری گرافیکی و مدیریت XML است. این اصل مسئولیت واحد را نقض می کند.

3. **Magic Numbers**:
 - مقادیر هاردکد مانند «1500»، «750» و «1999» در کد ظاهر می‌شوند. اینها باید با ثابت های نامگذاری شده جایگزین شوند تا خوانایی و قابلیت نگهداری بهبود یابد.

4. **Global State**:
 - چندین متغیر ثابت ('documentFactory', 'documentBuilder', 'document', 'frame', 'transformer', 'guiDiagram', 'counter') حالت جهانی را معرفی می کنند که می تواند منجر به مشکلات همزمان و آزمایش شود.

5. **Inconsistent Naming Conventions**:
 - متغیرها و روش‌ها از قراردادهای نام‌گذاری متفاوتی استفاده می‌کنند (به عنوان مثال، «generateInfoForXML» در مقابل «initializeGUI»). به یک سبک نامگذاری ثابت، مانند camelCase برای متدها و متغیرها، پایبند باشید.

6. **Duplicated Code**:
 - منطق مدیریت "BasicDiagramStatus" و "GraphOperation" در هر دو "generateInfoForXML" و "loopOnGUI" تکرار شده است. این کد باید به روش‌های جداگانه تغییر داده شود تا کپی‌سازی کاهش یابد.

7. **Deep Nested Code**:
 - متد "اصلی" شامل شرط ها و حلقه های عمیق تو در تو است که پیروی از منطق را دشوار می کند. تبدیل مجدد به روش های کوچکتر و متمرکزتر، خوانایی را بهبود می بخشد.

8. **Emptu `catch` Blocks**:
 - برخی از بلوک‌های «catch»، مانند بلوک «ParserConfigurationException» و «TransformerConfigurationException»، فقط ردیابی پشته را چاپ می‌کنند. برای مدیریت موثر استثناها، باید مدیریت صحیح خطا را اجرا کرد.

9. **Long Method**:
 - روش‌هایی مانند «اصلی» و «initializeGUI» بسیار طولانی هستند و چندین کار را انجام می‌دهند. اینها باید به روشهای کوچکتر و متمرکزتر تقسیم شوند.

10. **Tight Coupling**:
 - این کد اجزای مختلف، مانند مدیریت XML و عملیات رابط کاربری گرافیکی را با هم پیوند می دهد، و اصلاح یا آزمایش قطعات برنامه به طور مستقل را دشوار می کند. معرفی رابط ها یا الگوهای طراحی (مانند MVC) می تواند به جداسازی این مؤلفه ها کمک کند.

## سوال 5
**پلاگین Formatter** یک ابزار نرم‌افزاری است که کد منبع را به صورت خودکار قالب‌بندی می‌کند تا از خوانایی و یکنواختی آن اطمینان حاصل شود. این پلاگین معمولاً برای زبان‌های برنامه‌نویسی مختلف موجود است و می‌تواند کد را با توجه به تنظیمات خاصی مانند تورفتگی، فاصله‌گذاری، چیدمان خطوط و دیگر قوانین قالب‌بندی، به شکلی استاندارد و قابل خواندن درآورد.

**کمک‌کنندگی پلاگین Formatter:**
1. **افزایش خوانایی کد**: با ایجاد یک قالب یکنواخت و منظم برای کد، خواندن و درک آن برای توسعه‌دهندگان آسان‌تر می‌شود.
2. **صرفه‌جویی در زمان**: توسعه‌دهندگان نیاز به انجام دستی قالب‌بندی کد ندارند و می‌توانند بر روی نوشتن و بهبود منطق برنامه تمرکز کنند.
3. **کاهش خطاها**: با جلوگیری از اشتباهات کوچک ناشی از قالب‌بندی نامناسب، کیفیت کد افزایش می‌یابد.
4. **بهبود همکاری تیمی**: با استفاده از یک استاندارد قالب‌بندی مشترک، کد نوشته شده توسط چندین توسعه‌دهنده یکدست و یکنواخت می‌شود، که همکاری و نگهداری کد را آسان‌تر می‌کند.

**رابطه پلاگین Formatter با بازآرایی کد:**
- **هم‌تکمیلی با بازآرایی کد**: در حالی که بازآرایی کد (Refactoring) به تغییر ساختار داخلی کد برای بهبود کیفیت و عملکرد آن می‌پردازد بدون تغییر رفتار خارجی، پلاگین Formatter به بهبود ظاهر و خوانایی کد کمک می‌کند. هر دو ابزار در کنار هم می‌توانند به بهبود کیفیت کلی کد کمک کنند.
- **پشتیبانی از بازآرایی‌ها**: پس از انجام بازآرایی کد، پلاگین Formatter می‌تواند کد جدید را به سرعت قالب‌بندی کرده و از خوانایی آن اطمینان حاصل کند. این عمل به ویژه در پروژه‌های بزرگ که بازآرایی‌های مکرر انجام می‌شود، بسیار مفید است.

به طور کلی، پلاگین Formatter و بازآرایی کد دو ابزار مکمل هستند که به بهبود کیفیت و خوانایی کد کمک می‌کنند. Formatter به صورت خودکار و سریع قالب‌بندی مناسب را اعمال می‌کند، در حالی که بازآرایی کد بهبود ساختار و منطق کد را هدف قرار می‌دهد.
