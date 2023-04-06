#### 2023 전공기초프로젝트 11 차기획서

# 주소록 관리 프로그램:

# KUdressbook

#### 3238 B 01 팀

- [202211389 최준규](https://github.com/junkyn)
- [202211392 최  환](https://github.com/Hwan616)
- [202211342 이율원](https://github.com/sterdsterd)
- [201911277 장세현](https://github.com/nofeboy)


## 목차


- 1 프로젝트개요..............................................................................................................................
   - 1.1목적.....................................................................................................................................................
   - 1.2대상.....................................................................................................................................................
   - 1.3예상기대효과.......................................................................................................................................
- 2 용어..........................................................................................................................................
- 3 사용흐름도.................................................................................................................................
- 4 프로그램내용..............................................................................................................................
   - 4.1주소록요소..........................................................................................................................................
      - 4.1.1아이디........................................................................................................................................
      - 4.1.2비밀번호.....................................................................................................................................
      - 4.1.3이름...........................................................................................................................................
      - 4.1.4전화번호.....................................................................................................................................
      - 4.1.5주소...........................................................................................................................................
      - 4.1.6생일...........................................................................................................................................
      - 4.1.7메모.........................................................................................................................................
   - 4.2프로그램기능....................................................................................................................................
      - 4.2.1로그인및회원가입....................................................................................................................
         - 4.2.1.1로그인.............................................................................................................................
         - 4.2.1.2회원가입.........................................................................................................................
         - 4.2.1.3로그아웃.........................................................................................................................
      - 4.2.2주소록열람..............................................................................................................................
      - 4.2.3연락처검색..............................................................................................................................
      - 4.2.4연락처추가..............................................................................................................................
      - 4.2.5연락처수정..............................................................................................................................
      - 4.2.6연락처삭제..............................................................................................................................
      - 4.2.7내정보수정..............................................................................................................................
      - 4.2.8도움말......................................................................................................................................
      - 4.2.9종료.........................................................................................................................................
- 5 데이터파일...............................................................................................................................
   - 5.1문법규칙...........................................................................................................................................
      - 5.1.1기본규칙..................................................................................................................................
      - 5.1.2회원정보데이터파일규칙및예시.............................................................................................
      - 5.1.3개인별데이터파일규칙및예시.................................................................................................
   - 5.2의미규칙...........................................................................................................................................
   - 5.3부가확인목록....................................................................................................................................
   - 5.4무결성확인및처리............................................................................................................................
- 6 주프롬프트...............................................................................................................................
   - 6.1도움말...............................................................................................................................................
   - 6.2종료..................................................................................................................................................
   - 6.3로그인&가입명령어군.....................................................................................................................
      - 6.3.1로그인......................................................................................................................................
      - 6.3.2회원가입...................................................................................................................................
      - 6.3.3로그아웃...................................................................................................................................
   - 6.4열람..................................................................................................................................................
   - 6.5추가..................................................................................................................................................
   - 6.6삭제..................................................................................................................................................
   - 6.7수정..................................................................................................................................................
   - 6.8검색..................................................................................................................................................
- 7 예외처리..................................................................................................................................
   - 7.1동명이인............................................................................................................................................
   - 7.2중복전화번호....................................................................................................................................
   - 7.3이름이정수(Integer).........................................................................................................................
   - 7.4주소록요소들에탭문자(\t)존재.........................................................................................................
   - 7.5문법오류...........................................................................................................................................


## 1 프로젝트개요..............................................................................................................................

### 1.1목적.....................................................................................................................................................

###### 프로젝트의목적은사용자가자신이가진주소록정보를보다효율적이고체계적으로관리할수있도록도와주는CLI

###### 기반주소록관리프로그램을개발하는것이다.이프로그램은아이디와비밀번호를통한로그인기능을제공하며,내

###### 정보보기및주소록열람,수정,삭제,검색기능이있다.

### 1.2대상.....................................................................................................................................................

###### 이프로그램은기본적으로건국대학생을대상으로하나,주소록을관리하고싶어하는사용자라면누구나사용이

###### 가능하다.

### 1.3예상기대효과.......................................................................................................................................

###### 이프로그램을통해사용자가CLI기반환경을통해빠르고정확하게주소록정보를관리할수있을것으로기대된다.

## 2 용어..........................................................................................................................................

```
● 프로그램: 이문서를통해기획·명세하고있는대상프로그램인“KUdressBook”프로그램
● 사용자: 프로그램을사용하는주체
● 연락처: 이름,전화번호,주소,생일,메모를가진객체
● 주소록: 연락처들을모아둔목록
● 내정보: 사용자의이름,전화번호,주소,생년월일을가진객체(연락처와달리메모가없음)
● 연락처열람상태: 하나의연락처를열람해주소록수정,삭제를할수있는상태
● 로그인: 등록되어있는사용자의아이디와비밀번호를입력받고해당사용자의주소록을불러옴
● 회원가입: 사용자를새로등록해새로운주소록을생성
● 도움말: 사용자가입력할수있는명령어들과그에대한설명
● <value>: 사용자의입력값으로서,문자형데이터또는정수형데이터이다.
● 페이지: 출력되는 연락처의목록이 10개를 초과할 때,10개씩 나누어구분하고출력한다.이때구분된
연락처들의단위를페이지라고한다.
● 로그인/회원가입창: 프로그램에서로그인이나회원가입을요구하는상태
● 숫자: 0 U+0030– 9 U+0039만을의미하며,아랍숫자,데바나가리숫자,로마숫자등이외의숫자는포함되지않음
● 공백 :U+0020을의미하며,아래의문법예시에서는시인성을위해‘␣’로표기한다
```

```
● Tab문자 :U+0009를의미하며,아래문법예시에서는시인성을위해‘⇥’로표기한다
```
## 3 사용흐름도.................................................................................................................................

```
그림1.사용흐름도
```

## 4 프로그램내용..............................................................................................................................

### 4.1주소록요소..........................................................................................................................................

###### 주소록요소에는크게아이디,비밀번호,이름,전화번호,주소,생일,메모가있다.

```
각요소마다동치비교규칙이나,검색시의검색어합치Matching규칙도서로다르므로,아래의각요소별소절에서해당
요소의동치비교규칙과검색어합치규칙을각각명시한다.단,정렬시의순서는LexicographicOrder를따른다.
```
#### 4.1.1아이디........................................................................................................................................

```
아이디는사용자가로그인에사용할아이디다.사용자를식별하기위한Unique한값이다.
문법형식: 문법적으로올바른아이디는아래두조건을모두만족시키는문자열이다:
● 길이가 5 이상
● 숫자(‘0’-‘9’)또는알파벳대소문자(‘a’-‘z’,‘A’-‘Z’)로만구성되어야함
의미규칙: 사용자를식별하기위해Unique해야한다.
동치비교: 두아이디간의동치를비교할때에는,두이름간의동치비교를할때에는,두문자열전체에포함된모든
문자(공백포함)의순서와내용이서로완전히일치해야만같은아이디으로간주한다.
검색규칙: 아이디는로그인및회원가입에서만사용되고,검색에서사용되지않는다.
```
#### 4.1.2비밀번호.....................................................................................................................................

###### 비밀번호는사용자가로그인에사용할비밀번호다.로그인하려는사용자가아이디의소유주와동일한지확인하는

###### 용도로사용된다.

###### 문법형식: 문법적으로올바른비밀번호는아래모두만족시키는문자열이다:

###### ● 길이가 8 이상

```
● Whitespace를포함할수없음
● 알파벳대소문자(‘a’-‘z’,‘A’-‘Z’),숫자(‘0’-‘9’)또는특수문자로만구성되어야함
의미규칙: 비밀번호에는아무런추가적인의미규칙이없다.
```

###### 동치비교: 두비밀번호간의동치를비교할때에는,두이름간의동치비교를할때에는,두문자열전체에포함된

###### 모든문자(공백포함)의순서와내용이서로완전히일치해야만같은비밀번호으로간주한다.

###### 검색규칙: 비밀번호는로그인및회원가입에서만사용되고,검색에서사용되지않는다.

#### 4.1.3이름...........................................................................................................................................

###### 이름은말그대로이름이다.사람의이름이나,기업의이름등이될수있으며,심지어개개인을식별하기위한아무

###### 정보가포함되어도된다.또한동명이인의경우가있을수있으므로,이름의중복은허용된다.필수입력사항이다.

###### 문법형식: 문법적으로올바른이름은아래4개의조건을모두만족시키는문자열이다:

###### ● 길이가 1 이상

###### ● 첫문자와마지막문자는실상문자

###### ● 숫자만으로구성된문자열은이름이될수없음

###### ● 탭문자나개행문자를포함하지않음

###### 예를들어,‘최환’과‘최준규(건컴22)’,‘비빔밥미래인재양성부장관이율원’,심지어‘ᄋ’,‘!@^#@’모두문법적으로

###### 올바른이름이다.

###### 의미규칙: 이름에는아무런추가적인의미규칙이없다.

###### 동치비교: 두이름간의동치비교를할때에는,두문자열전체에포함된모든문자(공백포함)의순서와내용이서로

###### 완전히일치해야만같은이름으로간주한다.

```
예를들어,‘최환’과‘최환’은다른이름이고,‘SeanStorey’와‘seanstorey’도다른이름이다.
검색규칙: 검색명령의인자로서이름을활용하여주소록에저장된연락처를찾을때에는:
● 저장된이름속의공백류들을전부무시하고(공백류없이모두붙어있는문자열로간주하고)
● 대소문자를구분하지않으면서
● 검색어가이름의부분문자열이거나검색어가초성만으로이루어졌을경우,이름에해당초성이포함되어있을
경우합치된것으로간주한다.
예를들어 검색어가‘최준규’일 때, 저장된 연락처의이름들중‘최준규’뿐만아니라 ‘최준규’,‘최준규’도모두
합치된다.또한‘비빔밥’이검색어일때,저장된연락처의이름들중‘비빔밥미래인재양성부장관이율원’,‘제육비빔밥
```

###### 전문위락식당’,‘유비빔밥집’모두합치된다.또한,검색어가‘ᄎᄒ’일경우저장된연락처의이름중‘최환’,‘ᄎ환’,‘최

```
환’모두합치된다.또한검색어가‘SeanStorey’일경우,저장된연락처의이름중‘Seanstorey’,‘se anstorey’
모두합치된다.
참고로,대소문자를구분하지않을경우는,영문자A-Z,a-z만해당된다.그리스문자,키릴문자등영어알파벳
대소문자52자를제외한모든문자에대해서는대소문자를철저히구분한다.
```
#### 4.1.4전화번호.....................................................................................................................................

###### 이프로그램은‘전화번호’요소로휴대전화번호와유선전화번호를모두표현할수있다.필수입력사항이다.

###### 문법형식: 문법적으로올바른전화번호는아래6개의조건을모두만족시키는문자열이다.

###### ● 1개이상의숫자들과0개이상의‘-U+002D’문자들로만구성되어야함(횡공백류열은포함하지않음)

###### ● 첫문자와마지막문자는숫자여야함

###### ● ‘-U+002D’는연속되어나올수없음

###### ● 처음세문자가‘010’이면,이후숫자는(‘-U+002D’가몇개든상관없이)정확히8개여야만함

###### ● 처음두문자가‘01’로시작하고,세번째문자가‘0’이이나면,이후숫자는(‘-U+002D’가몇개든상관없이)7개

###### 혹은8개가있어야함

###### 예를들어,‘010-8496-3744’나,‘01087399719’,‘021234567’,‘112’,‘011-23456789’,‘1’은모두올바른

###### 전화번호지만,‘123-’,‘011--123-4567’,‘1 234 9’는올바른전화번호가아니다.

###### 의미규칙: 전화번호에는아무런추가적인의미규칙이없다.

###### 동치비교: 두전화번호간동치비교를할때에는,두문자열내부의‘-U+002D’를모두무시한채로,그문자열전체가

###### 서로완전히일치해야만같은전화번호로간주한다.

###### 예를 들어, ‘010-8496-3744’와 ‘01084963744’는 서로 같은 전화번호지만, ‘010-8496-3744’와

###### ‘8496-3744’는서로다른전화번호이다.

###### 검색규칙: 검색명령의인자로서 전화번호를활용하여주소록에 저장된연락처를찾을때에는,검색어와저장된

###### 전화번호내부의‘-U+002D’문자를모두무시한채로,검색어가전화번호의부분문자열이면합치된것으로간주한다.


###### 예를 들어, 검색어가 ‘112’일 경우, 저장된 전화번호들 중 ‘112’와 ‘010-1123-4567’뿐만 아니라

###### ‘011-234-5678’,‘031-123-4567’까지도모두합치된다.

#### 4.1.5주소...........................................................................................................................................

###### 주소는개인이나 업체의집주소,또는사무실주소등을담기위한필드이다.필수입력사항은아니며,사용자의

###### 선택에따라주소를입력하거나입력하지않을수있다.

###### 문법형식: 문법적으로올바른주소는아래세조건에모두부합하는문자열이다:

###### ● 공백(U+0020)을제외한모든횡공백류열(탭,개행등)을사용할수없음

###### ● 1개이상의문자,숫자,공백문자들로만구성되어야함

###### ● 공백문자는연속되어나올수없음

###### 위규칙은주소의형식을제한하지만,현실적인주소의형식에는제약이있다.따라서,위규칙에따라사용자의입력을

###### 처리한후에도,주소가현실적인형식에부합하는지를검증해야하지만,별도의검증없이사용하도록한다.

###### 의미규칙: 주소에는아무런추가적인의미규칙이없다.

###### 동치비교: 두주소간동치비교를할때에는,두문자열내부의공백(U+0020)을모두무시한채로,그문자열전체가

###### 서로완전히일치해야만같은주소로간주한다.

###### 예를들어, ‘광진구 능동로120’과‘광진구 능동로 120’은같은주소이지만,‘서울특별시광진구능동로120’과

###### ‘광진구능동로120’은다른주소이다.

###### 검색규칙: 검색명령의인자로서주소를활용하여주소록에저장된연락처를찾을때에는,검색어와저장된주소

###### 내부의공백(U+0020)문자를모두무시한채로,검색어가주소의부분문자열이면합치된것으로간주한다.

###### 예를들어,검색어가‘광진’일경우,저장된주소들중‘광진구능동로120’,‘서울시광진구아차산로1’,‘대구수성구

###### 광진슈퍼’모두합치된다.

#### 4.1.6생일...........................................................................................................................................

###### 생일은개인의생일정보를담기위한필드로,필수입력사항은아니며,사용자의선택에따라생일을입력하거나

###### 입력하지않을수있다.


###### 문법형식: 문법적으로올바른생일은아래25개의조건에모두부합하는문자열이다:

###### ● 숫자,‘/U+002F’,‘-U+002D’,‘.U+002E’으로만구성되어야함

###### ● 연도,월,일순으로구성되어야함

###### ● 연도는숫자4개,월,일은숫자한개또는두개로구성되어야함

###### ● 연도,월,일은‘/U+002F’,‘-U+002D’,‘.U+002E’로구분되거나모두붙여써야함

###### ○ 모두붙여쓸경우월,일은숫자두개로만구성되어야함

###### ● 연도의첫자리는숫자‘1’또는‘2’만허용되고,이외의자리는‘0’-‘9’가모두허용됨

###### ● 월이숫자두개로구성되어있을때:

###### ○ 첫자리가‘0’일경우,둘째자리는‘0’-’9’로만이루어져야함

###### ○ 첫자리가‘1’일경우,둘째자리는‘1’또는‘2’로만이루어져야함

###### ● 월이숫자하나로구성되어있을때:

###### ○ ‘1’-‘9’로만이루어져야함

###### ● 일이숫자두개로구성되어있을때:

###### ○ 첫자리가‘0’일경우,둘째자리는‘1’-‘9’로만이루어져야함

###### ○ 첫자리가‘1’일경우,둘째자리는‘0’-‘9’로만이루어져야함

###### ○ 첫자리가‘2’이면서,

###### ■ 2월이면서,

###### ● 연도가윤년일경우,둘째자리는‘0’-‘9’로만이루어져야함

###### ● 연도가평년일경우,둘째자리는‘0’-‘8’로만이루어져야함

###### ■ 2월이아닐경우,둘째자리는‘0’-‘9’로만이루어져야함

###### ○ 첫자리가‘3’이면서,

###### ■ 월이‘1’,‘01’,‘3’,‘03’,‘5’,‘05’,‘7’,‘07’,‘8’,‘08’,‘10’,‘12’일경우,둘째자리는‘0’또는

###### ‘1’로만이루어져야함

###### ■ 월이‘4’,‘04’,‘6’,‘06’,‘9’,‘09’,‘11’일경우,둘째자리는‘0’으로만이루어져야함

###### ○ 단,월이‘2’또는‘02’일경우는첫자리를‘3’으로가질수없음

###### ● 일이숫자하나로구성되어있을때:

###### ○ ‘1’-‘9’로만이루어져야함


###### 예를들어,‘2003/6/12’,‘2003.06.12’,‘2017-5-11’,‘20170511’,‘10000101’은모두올바른생일이지만,

###### ‘030612’,‘2017511’,‘2023/02/29’,‘20111355’,‘00000000’은올바른생일이아닙니다.

###### 의미규칙: 생일에는아무런추가적인의미규칙도없다.(의도한모든규칙을문법으로전부표현했다.)

```
동치비교: 두생일간의동치비교를할때에는,두문자열에서연도,월,일을추출하여LeadingZero를무시한후
각각비교하되,서로완전히일치해야만같은생일로간주한다.
예를 들어, ‘2003/06/12’, ‘20030612’, ‘2003.6.12’는 모두 같은 생일이지만, ‘2003/06/12’와
‘2004/06/12’는다른생일이다.
검색규칙: 검색명령의인자로서생일를활용하여주소록에저장된연락처를찾을때에는,검색어와저장된생일
문자열의 Seperator를제거하고, 월,일에 Leading Zero를붙여각각두글자로만들어(yyyyMMdd)포맷으로
만들어검색어가이와앞에서부터순서대로비교하여같으면합치된것으로간주한다.
예를 들어, 검색어가 ‘2003/6/12’이면 ‘20030612’,‘2003.06.12’ 모두합치되고, 검색어가‘2003.06’이면
‘2003/6/12’, ‘2003/06/27’ 모두 합치되고, 검색어가 ‘2002.1’이면 ‘2002/1/23’, ‘2002-01-25’ 모두
합치되지만,‘2002.12.25’는합치되지않는다.
```
#### 4.1.7메모.........................................................................................................................................

###### 메모는개인의기타정보를담기위한공간으로,필수입력사항은아니며,사용자의선택에따라메모를입력하거나

###### 입력하지않을수있다.

```
문법형식: 문법적으로올바른메모는아래n개의조건에모두부합하는문자열이다:
● 탭문자,공백,문자,숫자로만구성되어야함
● 1개이상의character로구성되어야함
● 첫문자와마지막문자는실상문자여야함
예를들어‘건컴␣멋쟁이’,‘건컴⇥2학년⇥과대’등은모두올바른메모이지만,‘비빔밥(개행)미래인재양성부
장관’,‘␣건대␣스융공’은문법적으로올바른메모가아니다.
의미규칙: 메모에는아무런추가적인의미규칙도없다.
동치비교: 두메모간동치비교를할경우,두문자열전체가서로완전히일치해야만같은메모로간주된다.
```

###### 검색규칙: 검색명령의인자로서메모를활용하여주소록에저장된연락처를찾을때에는,검색어와저장된메모

###### 문자열의모든횡공백류열을무시한채로,검색어가메모의부분문자열이면합치된것으로간주한다.

###### 예를들어,‘비빔밥’이검색어일경우,저장된메모중‘비빔밥회장’과‘건대비빔밥맛집’뿐만아니라,‘비 빔밥부

###### 회장’까지도모두합치된다.

### 4.2프로그램기능....................................................................................................................................

#### 4.2.1로그인및회원가입....................................................................................................................

```
● 프로그램시작시“login이나register을통해로그인이나회원가입을해주세요”가출력된다···(1)
● “login”,“register”,“exit”이외의입력에는전부(1)로돌아간다.
```
##### 4.2.1.1로그인.............................................................................................................................

```
● “login (아이디) (비밀번호)”를 입력받았을 때 입력한 아이디가 존재하지 않으면 “존재하지 않는
아이디입니다”가출력되고(1)로돌아간다.
```
```
그림2.존재하지않는아이디예시
● 입력한 아이디가 존재한다면 비밀번호를체크하는데, 아이디에 해당하는비밀번호와일치하지않는다면
번호가틀립니다”가출력되고(1)로돌아간다.
```
```
그림3.비밀번호오류예시
```

###### ● 입력한비밀번호가아이디에해당하는비밀번호와일치한다면“(사용자이름)님환영합니다”가출력되고

###### 도움말이출력된다.

```
그림4.로그인성공예시
```
##### 4.2.1.2회원가입.........................................................................................................................

```
● “register”를입력받으면“아이디를입력해주세요”가출력되며아이디입력을받는다.
● 입력한아이디가이미존재하면“존재하는아이디입니다.”가출력되고(1)로돌아간다.
```
```
그림5.아이디중복예시
```

###### ● 중복된아이디가아니라면“비밀번호를입력해주세요”가출력된다.

###### ● 비밀번호를입력받은후“계정이생성되었습니다”가출력되고사용자정보를입력받는다.

###### ● “이름을입력해주세요”가출력되고이름을입력받는다.

###### ● “전화번호를입력해주세요”가출력되고전화번호를입력받는다.

###### ● “주소를입력해주세요”가출력되고주소를입력받는다.

###### ● “생년월일을입력해주세요(0000/00/00)”가출력되고생일을입력받는다.

###### ● 모든입력이끝난후(1)로돌아간다.

```
그림6.회원가입성공예시
```
##### 4.2.1.3로그아웃.........................................................................................................................

```
● “logout”을입력받으면로그아웃이되고(1)로돌아간다.
```
```
그림7.로그아웃예시
```
#### 4.2.2주소록열람..............................................................................................................................

```
● “view<value>”를입력받으면사용자의주소록을열람한다.
```

###### ● 사용자의연락처들의개수가10개가넘는다면,10개를기준으로나눠페이지가생성된다.

● <value>가 공백이라면, 1페이지의 주소록을 출력해준다. 주소록은 기본적으로 이름의 사전 순서로
정렬된다.

```
그림8.주소록열람예시
```
● <value>가정수형데이터라면,입력받은페이지의주소록을출력해준다.

```
그림9.주소록2페이지열람예시
```
● 입력받은정수의페이지가존재하지않는다면,“존재하지않는페이지입니다”를출력한다.


```
그림10.존재하지않는주소록페이지열람예시
```
● 당시날짜가생일인연락처가있을경우주소록1페이지를출력할때생일인연락처를출력해준다.

```
그림11.생일자출력예시
```
● <value>가문자형 데이터라면입력받은문자열의이름을가진연락처를출력해주고연락처열람상태에
들어간다.후에언급할사례를제외하면다른기능을수행할때연락처열람상태에서빠져나온다.

```
그림12.특정연락처열람예시
```

###### ● 입력받은문자열의이름을가진연락처가없다면,“존재하지않는연락처입니다”를출력한다.

```
그림13.존재하지않는연락처검색예시
```
#### 4.2.3연락처검색..............................................................................................................................

```
● “search<value>”를입력받으면연락처검색을수행한다.
● 각연락처들의모든요소들을문자열로검사해<value>값을포함한다면출력해준다.
● 만약 출력할 연락처들의 개수가 10개가 넘는다면, 주소록 열람과 똑같이 10개를 기준으로 페이지를
생성한다.
● “search<value><int>”형식으로<int>에해당하는페이지를출력하고,<int>가공백이라면1페이지를
출력한다.
```
```
그림14.“구스”가포함된연락처검색예시
```
#### 4.2.4연락처추가..............................................................................................................................

```
● “add”를입력받으면연락처를추가하는작업을수행한다.
● 먼저이름을입력받고전화번호를입력받는다.
● 중복된전화번호는4.3부가확인목록에서서술한다.
● 새로운전화번호라면,주소와생년월일,메모를입력받는다.
```

```
그림15.연락처추가예시
```
#### 4.2.5연락처수정..............................................................................................................................

```
● 연락처열람상태가아닐때“edit”을입력하면“수정할연락처를열람해주세요”를출력한다
```
```
그림16.연락처열람상태가아닐때“edit”입력예시
● “view<String>”으로해당이름을가진연락처를열람하고있을때,“edit”을입력하면연락처수정기능을
수행한다.
● 수정할 부분을 입력받는데, 입력받은값이 name이라면 이름을, num이라면 전화번호를, address라면
주소를,birth라면생년월일을,memo라면메모를다시입력받아수정해준다.
● cancel을입력받을때까지수정을반복한다.
● 연락처수정이끝나도연락처열람상태를유지한다.
```

```
그림17.연락처수정예시
```
#### 4.2.6연락처삭제..............................................................................................................................

```
● 연락처열람상태가아닐때“delete”를입력하면“삭제할연락처를열람해주세요”를출력한다.
```
```
그림18.연락처열람상태가아닐때“delete”입력예시
● “view <String>”으로해당이름을가진연락처를열람하고있을때,“delete”를입력하면연락처삭제
기능을수행한다.
● 삭제를하기전“정말삭제하시겠습니까?삭제를원하시면“삭제”를입력해주세요”를출력하고문자열을
입력받는다.
● “삭제”를입력받으면삭제를진행한다.
```

```
그림19.연락처삭제예시
● “삭제”를입력받지않으면해당연락처를삭제하지않고연락처열람상태를유지한다.
```
```
그림20.삭제취소예시
```
#### 4.2.7내정보수정..............................................................................................................................

```
● “myprofile”을입력받으면내정보를출력하고수정할부분을입력받는다.
● 입력받은부분이name이라면이름을,num이라면전화번호를,address라면주소를,birth라면생년월일을
다시입력받아수정해준다.
● cancel을입력받을때까지수정을반복한다.
● 수정후수정된내정보를출력해준다.
```

```
그림21.내정보수정예시
```
#### 4.2.8도움말......................................................................................................................................

```
● “help”를입력받으면사용자가입력할수있는명령어들과그에대한설명을출력해준다.
```
```
그림22.도움말예시
```
#### 4.2.9종료.........................................................................................................................................

```
● “exit”을입력하면프로그램이종료된다.
```

```
그림23.프로그램종료예시
```
## 5 데이터파일...............................................................................................................................

###### ● 기본적으로,이프로그램은실행중에사용자로부터연락처정보를 키입력으로받아들이고이정보들을

###### 프로그램스스로내부기능을통해데이터파일에저장한다.

```
● 모든사용자의아이디,비밀번호및개인정보를담은File하나와각유저의개인별연락처를담은개인별
연락처File로구성된다.
● 사용자가별도의텍스트편집기를이용해데이터파일을(프로그램을통하지않고)직접생성/편집/저장하는
방식도지원한다.단:
○ 프로그램이실행되고있는중데이터파일을직접편집할경우,정상작동을보장하지않는다.
○ 데이터파일은(BOM없는)UTF-8인코딩으로저장되어야한다.
○ 운영체제마다개행문자들을다루는기본방식이서로다르지만(LF,CRLF등)이프로그램은모든
개행방식을똑같이다루므로,어떤OS에서어떤방식으로저장하여도상관없다.
○ 이절에서정하는문법과의미규칙을준수하며편집해야만프로그램이정상적으로동작한다.
● 사용자는문법에만맞다면얼마든지데이터파일을수정해도되지만,데이터의무결성을보장할수없으므로
권장하지는않는다.
● 위마지막항목에의거하여,사용자가데이터파일을올바르게편집하고어떤상황에서어떤결과가나올지
정확히예상할수있도록데이터파일의문법(형식)과의미규칙(추가조건)들을명시한다.
```
### 5.1문법규칙...........................................................................................................................................

#### 5.1.1기본규칙..................................................................................................................................

```
● 기본적으로 데이터 파일은 Tab DelimitedValue형식으로 작성되며, Column은Tab문자U+00091개로,
Row는개행으로구분한다.
● 각각의Row는각Field와Tab문자를번갈아가며입력되며,Field는비어있을수있다.
● 위경우Tab문자가두번이상등장할수있다.
```

#### 5.1.2회원정보데이터파일규칙및예시.............................................................................................

```
회원정보데이터파일에저장될Field들은다음과같다.
● 아이디필수항목
● 비밀번호필수항목
● 이름필수항목
● 전화번호필수항목
● 주소선택항목
● 생년월일선택항목
각각의 항목들은 위순서대로 Tab문자(이하예시에서는 Tab문자를 시각적으로 표현하기위해‘⇥’로표기)로
구분되어한줄로구성되어야한다.선택항목을공란으로비워두는경우,Tab문자를한번더입력한후다음항목을
바로입력한다.
예를 들어, 아이디가 ‘sterdsterd’이고, 비밀번호가 ‘1q2w3e4r’이고, 이름이 ‘이율원’이고, 전화번호가
‘010-8496-3744’이고,주소가‘광진구능동로120’이고,생년월일이‘20030612’인사람의정보는다음과같이
표현할수있다.
sterdsterd⇥ 1 q 2 w 3 e 4 r⇥이율원⇥ 010 - 8496 - 3744 ⇥광진구능동로 120 ⇥ 20030612
처럼 표현한다. 또한, 아이디가 ‘kucse’이고, 비밀번호가 ‘1234’이고, 이름이 ‘김건컴’이고, 전화번호가
‘01012345678’이고,주소와생년월일이생략되어있는사람의정보는다음과같이표현할수있다,
kucse⇥ 1234 ⇥김건컴⇥ 01012345678 ⇥⇥
```
#### 5.1.3개인별데이터파일규칙및예시.................................................................................................

```
개인별데이터파일에저장될Field들은다음과같다.
● 이름필수항목
● 전화번호필수항목
● 주소선택항목
● 생일선택항목
● 메모선택항목
```

```
각각의 항목들은 위순서대로 Tab문자(이하예시에서는 Tab문자를 시각적으로 표현하기위해‘⇥’로표기)로
구분되어한줄로구성되어야한다.단,메모에는Tab문자가포함될수있기때문에,가장처음4개의Tab문자를
기준로하여각항목을구분한다.선택항목을공란으로비워두는경우,Tab문자를한번더입력한후다음항목을
바로입력한다.
예를들어, 이름이 ‘이율원’이고,전화번호가 ‘010-8496-3744’이고,주소가 ‘광진구 능동로120’이고,생일이
‘20030612’이고,메모가‘컴공22비빔밥미래인재양성부장관’인사람의정보는다음과같이표현할수있다.
이율원⇥ 010 - 8496 - 3744 ⇥광진구능동로 120 ⇥ 20030612 ⇥컴공 22 비빔밥미래인재양성부장관
처럼 표현한다. 또한, 아이디가 ‘kucse’이고, 비밀번호가 ‘1234’이고, 이름이 ‘김건컴’이고, 전화번호가
‘01012345678’이고, 주소와 생년월일이 생략되어있고,메모가‘컴공⇥2과대’인사람의정보는다음과 같이
표현할수있다,
kucse⇥ 1234 ⇥김건컴⇥ 01012345678 ⇥ ⇥⇥컴공⇥ 2 과대
```
### 5.2의미규칙...........................................................................................................................................

```
● 데이터파일속의서로다른두Row들속에는서로같은‘전화번호’가존재할수없다
```
### 5.3부가확인목록....................................................................................................................................

```
● 동일한이름이둘이상의Row에속하는경우,
● 동명이인이있는경우자동적으로추가된연락처이름뒤에(순서)가붙는다.
● 예를들어,김건국이있는상태에서김건국추가시김건국(1)이된다.
● 또한,김건국과김건국(1)이있는상태에서김건국추가시김건국(2)가된다.
```
### 5.4무결성확인및처리............................................................................................................................

###### ● 프로그램시작시파일을읽어주소록객체를생성하는데실패한다면실패메시지를출력하고종료한다.

```
그림24.파일읽기오류예시
```

## 6 주프롬프트...............................................................................................................................

###### ● 주프롬프트는화면에다음과같이현재선택한메뉴계층을출력하고,사용자의키입력을기다린다.

```
그림25.주프롬프트출력예시
● 문법형식: 주프롬프트에키입력하는올바른문법은다음형식과같다:
○ <명령어><공백><단어열>
○ 단,위의<명령어>자리에는반드시다음표의단어들중하나를써야하며,이들만이문법적으로
올바른‘명령어’다.
login register logout view search add
edit delete myprofile help exit
표1.올바른모든명령어들
● 해석: 명령어는이미문법형식에구분되어쓰여있으므로해석규칙이필요없다.<단어열>은(만일있다면)
그속의단어들각각을인자들로간주한다.
● 의미규칙: <명령어>자리에어떤명령어군에속한명령어가들어오는지에따라서,<단어열>중인식할
인자의개수가달라진다.인자들은공백으로구분되며만일인자들의개수가인식할인자보다많다면,초과된
인자들은전부무시한다.
```

```
그림26.초과된인자예시
```
명령어 인자개수 설명

login 2 개 데이터파일에서인자들을비교해로그인을진행

register 없음 회원가입을진행

logout 없음 로그인/회원가입창으로돌아감

view 없거나, 1 개 인자에따라연락처열람을진행

search 1 개또는 2 개 데이터파일에서인자를검색

add 없음 주소록에연락처를추가

edit 없음 열람하고있는연락처를수정

delete 없음 열람하고있는연락처를삭제

myprofile 없음 내정보를열람및수정

help 없음 프로그램에서사용가능한명령어목록출력

exit 없음 프로그램종료

```
표2.명령어들과인자규칙및설명
```

###### ● 문법오류결과: 만일주프롬프트에서입력한첫번째단어가명령어가아닐경우잘못된입력으로간주하고

###### 도움말을출력해준다.

```
그림27.잘못된입력예시
```
###### ● 의미오류혹은정상결과: 만일입력중첫번째단어가명령어가맞으면명령어별기능을수행한다.명령어별

###### 기능과 정상결과는 4.2절에서서술했으며, 아래에서는명령어 별인자문법형식과 비정상결과에대해

###### 서술하겠다.

### 6.1도움말...............................................................................................................................................

###### ● 인자문법형식: 인자가있더라도전부무시하고같은기능을수행한다.

###### ● 비정상결과: 비정상결과는존재하지않는다.

### 6.2종료..................................................................................................................................................

###### ● 인자문법형식: 인자가있더라도전부무시하고같은기능을수행한다.

###### ● 비정상결과: 비정상결과는존재하지않는다.

### 6.3로그인&가입명령어군.....................................................................................................................

#### 6.3.1로그인......................................................................................................................................

###### ● 인자 문법 형식: <아이디><공백><비밀번호> 순서로 입력받는다. 앞의 두개 인자를 제외한 추가적인

###### 인자들이있다면무시한다.


###### ● 비정상결과: 인자의수가부족하다면“입력오류”를출력한다.

```
그림28.로그인입력오류예시
```
#### 6.3.2회원가입...................................................................................................................................

###### ● 인자문법형식: 인자가있더라도전부무시하고같은기능을수행한다.

###### ● 비정상결과: 비정상결과는존재하지않는다.

#### 6.3.3로그아웃...................................................................................................................................

###### ● 인자문법형식: 인자가있더라도전부무시하고같은기능을수행한다.

###### ● 비정상결과: 비정상결과는존재하지않는다.

### 6.4열람..................................................................................................................................................

###### ● 1개보다많은인자가입력되면,앞의1개를제외한나머지인자들은무시한다.

###### ● 인자문법형식 1 : 인자가없다면,사용자의주소록의1페이지를열람한다.

###### ● 인자문법형식 2 : 인자가 정수 라면,인자에해당하는페이지의주소록을열람한다.

###### ● 인자문법형식 3 : 인자가 문자열 이라면,인자에해당하는이름을가진연락처를열람한다.

###### ● 비정상결과 1 : 인자가 정수 일때,인자에해당하는페이지가존재하지않는다면,오류메시지를출력한다.

###### ● 비정상 결과 2 : 인자가 문자열 일 때,인자에 해당하는 이름을 가진연락처가 존재하지 않는다면,오류

###### 메시지를출력한다.

### 6.5추가..................................................................................................................................................

###### ● 인자문법형식: 인자가있더라도전부무시하고같은기능을수행한다.

###### ● 비정상결과: 비정상결과는존재하지않는다.


### 6.6삭제..................................................................................................................................................

###### ● 인자문법형식: 인자가있더라도전부무시하고같은기능을수행한다.

###### ● 비정상결과: 4.2.6절에서서술했듯이연락처열람상태가아니라면“삭제할연락처를 열람해주세요”를

###### 출력한다.

### 6.7수정..................................................................................................................................................

###### ● 인자문법형식: 인자가있더라도전부무시하고같은기능을수행한다.

###### ● 비정상결과: 4.2.5절에서서술했듯이연락처열람상태가아니라면“수정할연락처를 열람해주세요”를

###### 출력한다.

### 6.8검색..................................................................................................................................................

###### ● 인자문법형식: 인자를 문자열 로1개만입력받고,그뒤의인자들은무시한다.

###### ● 비정상결과: 인자가없다면,“입력오류”를출력한다.

```
그림29.검색입력오류예시
```
## 7 예외처리..................................................................................................................................

### 7.1동명이인............................................................................................................................................

###### ● 동명이인이있는경우자동적으로추가된연락처이름뒤에(순서)가붙는다.

```
● ex)김건국이있는상태에서김건국추가시김건국(1)이된다.
```
### 7.2중복전화번호....................................................................................................................................

###### ● 만약주소록에같은전화번호를가진연락처가존재한다면,“이미존재하는전화번호입니다”를출력한다.


```
그림30.중복전화번호입력예시
```
### 7.3이름이정수(Integer).........................................................................................................................

###### ● 연락처추가에서이름을정수로입력한다면“정수로이뤄진이름은불가능합니다”를출력하고이름을다시

###### 입력받는다.

```
그림31.정수로이뤄진이름입력예시
```
### 7.4주소록요소들에탭문자(\t)존재.........................................................................................................

###### ● 프로그램에서데이터파일을저장하고불러올때,요소들을나누는기준이탭이므로,연락처를추가,수정,내

```
정보수정에서오류를발생시킬수있는탭을입력받으면“탭(tab)은입력하실수없습니다”를출력하고
해당요소를다시입력받는다.
```
```
그림32.탭문자(\t)입력예시
```

### 7.5문법오류...........................................................................................................................................

###### ● 4.1절에정의한요소들의문법형식에맞지않게입력하였을경우,각문법형식에대한안내를출력하며해당

###### 요소를다시입력받는다.

```
그림33.문법형식에맞지않는입력예시
```
```
그림34.문법형식에맞지않는입력예시 2
```

 

