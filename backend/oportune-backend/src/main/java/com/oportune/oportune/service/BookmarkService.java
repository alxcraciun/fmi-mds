package com.oportune.oportune.service;

import com.oportune.oportune.model.Bookmark;
import com.oportune.oportune.model.Opportunity;
import com.oportune.oportune.model.User;
import com.oportune.oportune.repository.BookmarkRepository;
import com.oportune.oportune.repository.OpportunityRepository;
import com.oportune.oportune.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final UserRepository userRepository;
    private final OpportunityRepository opportunityRepository;


    @Autowired
    public BookmarkService(BookmarkRepository bookmarkRepository, UserRepository userRepository, OpportunityRepository opportunityRepository) {
        this.bookmarkRepository = bookmarkRepository;
        this.userRepository = userRepository;
        this.opportunityRepository = opportunityRepository;
    }

    public Bookmark addBookmark(int userId, Long opportunityId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User with ID " + userId + " doesn't exist"));

        Opportunity opportunity = opportunityRepository.findById(opportunityId)
                .orElseThrow(() -> new IllegalStateException("Opportunity with ID " + opportunityId + " doesn't exist"));

        Bookmark bookmark = new Bookmark();
        bookmark.setUser(user);
        bookmark.setOpportunity(opportunity);

        return bookmarkRepository.save(bookmark);
    }

    public void deleteBookmarkById(long id) {
        boolean exists = bookmarkRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Bookmark with "+ id +" doesn't exist");
        }
        bookmarkRepository.deleteById(id);
    }

}
