# Gimal_SpringBoot

## 주요 기능

### 메인 페이지 (Doors)
- 3개의 선택 가능한 문
- 각 문으로 다른 섹션 이동

### 책 섹션 (Book)
- Unity 기초 학습 콘텐츠 목차
- 1강, 2강, Memo, Quiz 연동

### 별자리 페이지 (Night)
- 별똥별 애니메이션 (requestAnimationFrame 기반)
- 호버 시 별자리 이름 표시
- CSS :hover와 opacity 효과

### 포션 게임 (Potion)
- 드래그 앤 드롭: 재료를 항아리에 드래그
- 조합에 따라 항아리 이미지 변경 (7가지 색상)
- 리셋 기능

### 메모장 (Memo)
- LocalStorage 기반 자동 저장
- 새로고침 후에도 메모 유지

### 퀴즈 (Quiz)
- CSS :checked 선택자로 답안 표시
- JavaScript 없이 순수 CSS로 상호작용

---

## 기술 스택

```
Backend:       Spring Boot 3.2.5, Java 17
Frontend:      Thymeleaf 3.1.2, Vanilla JavaScript, CSS3
Server:        Tomcat 10.1 (내장)
Build Tool:    Maven
Package:       kr.ac.kopo.mose.gimalproject
```

---

## 프로젝트 구조

```
gimalproject/
├── pom.xml
├── src/main/
│   ├── java/kr/ac/kopo/mose/gimalproject/
│   │   ├── GimalprojectApplication.java       (@SpringBootApplication)
│   │   └── controller/
│   │       └── MainController.java            (@Controller, @GetMapping)
│   │
│   └── resources/
│       ├── application.properties             (서버 설정)
│       │
│       ├── templates/                         (Thymeleaf HTML)
│       │   ├── doors.html
│       │   ├── book.html
│       │   ├── night.html
│       │   ├── potion.html
│       │   └── bookin/
│       │       ├── chapter1.html
│       │       ├── chapter2.html
│       │       ├── memo.html
│       │       └── quiz.html
│       │
│       └── static/                            (정적 리소스)
│           ├── images/                        (PNG 이미지)
│           ├── images/jars/                   (포션 항아리)
│           └── font/                          (폰트 파일)
```

---

## 실행 방법

### 준비 작업

이미지/폰트 파일 복사 (필수)

```bash
# 원본 폴더의 이미지들을 아래 경로로 복사
src/main/resources/static/images/      # 모든 PNG 파일
src/main/resources/static/images/jars/ # 포션 항아리 이미지
src/main/resources/static/font/        # Dokdo.css 및 폰트 파일
```

### 프로젝트 실행

방법 1: Maven으로 실행 (권장)
```bash
cd gimalproject
./mvnw spring-boot:run
```

방법 2: IntelliJ에서 실행
1. IntelliJ IDEA 열기
2. File → Open → gimalproject 폴더 선택
3. GimalprojectApplication.java → Run 버튼 클릭

### 브라우저 접속
```
http://localhost:8080
```

---

## URL 매핑

| URL | 페이지 | 설명 |
|---|---|---|
| / | doors.html | 메인 (문 선택) |
| /book | book.html | 책 목차 |
| /night | night.html | 별자리 |
| /potion | potion.html | 포션 게임 |
| /bookin/chapter1 | chapter1.html | 1강 - 인터페이스와 입력장치 |
| /bookin/chapter2 | chapter2.html | 2강 - UI와 오디오 시스템 |
| /bookin/memo | memo.html | 메모장 |
| /bookin/quiz | quiz.html | 퀴즈 (5문제) |

---

## 사용된 주요 기술

### Spring Boot MVC
```java
@Controller
public class MainController {
    @GetMapping("/book")
    public String book() {
        return "book";  // templates/book.html 렌더링
    }
}
```

### Thymeleaf
```html
<a th:href="@{/book}">책 보기</a>
<img th:src="@{/images/ExBook.png}">
```

### Vanilla JavaScript - 드래그 앤 드롭
```javascript
el.addEventListener('dragstart', e => {
    e.dataTransfer.setData("text/plain", e.target.id);
});

function handleDrop(event) {
    const id = event.dataTransfer.getData("text/plain");
    droppedItems.add(id);
    updateJarImage();
}
```

### LocalStorage - 메모 저장
```javascript
// 자동 저장
memoEl.addEventListener('input', () => {
    localStorage.setItem('memoContent', memoEl.innerText);
});

// 자동 복원
const saved = localStorage.getItem('memoContent');
```

### CSS :checked - 퀴즈
```css
#q1x:checked ~ .a1 { display: block; }
```

---


## Author

모세 (hanmose)
KOPO 재학생 | Java & Spring Boot 학습 중
