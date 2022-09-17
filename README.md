 실전프로젝트1 _ Project1
# Java CRUD project with file I/O
22100033 고영서

Project Period : 2022.9.2 ~ 9.17
***

## Description
Project 1에서는 Java 리뷰를 위한 영어 단어장 CRUD 프로그램을 작성했다.

새로운 IDE에서 Maven Project 로 생성하였고 Git/Github를 이용해 프로젝트 소스를 모니터링하도록 했다.

Class, Override, Interface, Array List, Scanner / Git/Github, Markdown 등을 복습할 수 있는 기회가 되었다.

* 개발환경 및 언어 : IntelliJ에서 Java

## Classes
`Main Class` static main 함수. WordMan 인스턴스 생성 후 start

`Word Class` 데이터 클래스. id, level, word, meaning 4개의 필드, getter/setter, toString 포함.

`WordMan Class` WordCRUD를 사용한 실제 관리. selectMenu, wordCRUD 인스턴스 생성 후 메소드 사용.

`WordCRUD Class` ICRUD interface 구현체. ArrayList 생성, add, addWord, listAll 포함.

`ICRUD Interface` CRUD를 위한 interface.

## Results
#### [4. 단어 추가] 메뉴 실행화면
<img src="https://github.com/moooo33/sil_project1/blob/master/screenshot/4.%20%EB%8B%A8%EC%96%B4%EC%B6%94%EA%B0%80.png?raw=true" height="350">

#### [1. 모든 단어보기] 메뉴 실행화면
<img src="https://github.com/moooo33/sil_project1/blob/master/screenshot/1.%20%EB%AA%A8%EB%93%A0%20%EB%8B%A8%EC%96%B4%20%EB%B3%B4%EA%B8%B0.png?raw=true" height="350">

#### [0. 나가기] 메뉴 실행화면
<img src="https://github.com/moooo33/sil_project1/blob/master/screenshot/0.%20%EB%82%98%EA%B0%80%EA%B8%B0.png?raw=true" height="350">
