package com.oportune.oportune.controller;

import com.oportune.oportune.model.Bookmark;
import com.oportune.oportune.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @Autowired
    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @DeleteMapping("/deleteBookmark/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){ bookmarkService.deleteBookmarkById(id); return new ResponseEntity<>(HttpStatus.OK); }

    @PostMapping("/addBookmark/{userId}")
    public ResponseEntity<Bookmark> addBookmark(@PathVariable("userId") int userId, @RequestBody Map<String, Long> requestBody) {
        Long opportunityId = requestBody.get("opportunityId");
        if (opportunityId == null) {
            throw new IllegalArgumentException("opportunityId is missing in the request body");
        }

        Bookmark createdBookmark = bookmarkService.addBookmark(userId, opportunityId);
        return new ResponseEntity<>(createdBookmark, HttpStatus.CREATED);
    }

}


