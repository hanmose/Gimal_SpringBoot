package kr.ac.kopo.mose.gimalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 메인 페이지 컨트롤러
 * 각 URL 요청을 해당 Thymeleaf 템플릿으로 연결합니다.
 */
@Controller
public class MainController {

    // ─── 메인 (문 선택 화면) ───────────────────────────────
    @GetMapping("/")
    public String doors() {
        return "doors";
    }

    // ─── 책 목차 ──────────────────────────────────────────
    @GetMapping("/book")
    public String book() {
        return "book";
    }

    // ─── 별자리 ───────────────────────────────────────────
    @GetMapping("/night")
    public String night() {
        return "night";
    }

    // ─── 포션 드래그앤드롭 ─────────────────────────────────
    @GetMapping("/potion")
    public String potion() {
        return "potion";
    }

    // ─── BookIn : 1강 ──────────────────────────────────────
    @GetMapping("/bookin/chapter1")
    public String chapter1() {
        return "bookin/chapter1";
    }

    // ─── BookIn : 2강 ──────────────────────────────────────
    @GetMapping("/bookin/chapter2")
    public String chapter2() {
        return "bookin/chapter2";
    }

    // ─── BookIn : 메모 ─────────────────────────────────────
    @GetMapping("/bookin/memo")
    public String memo() {
        return "bookin/memo";
    }

    // ─── BookIn : 퀴즈 ─────────────────────────────────────
    @GetMapping("/bookin/quiz")
    public String quiz() {
        return "bookin/quiz";
    }
}
