package com.example.task1.blog.service.blogServiceImplementation;

import com.example.task1.blog.dto.BlogDto;
import com.example.task1.blog.entity.Blog;
import com.example.task1.blog.mappers.BlogMapper;
import com.example.task1.blog.repository.BlogRepositoryI;
import com.example.task1.blog.service.BlogServiceI;
import com.example.task1.user.entity.UserPrincipal;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlogServiceImplementation implements BlogServiceI {

    @Autowired
    private final BlogRepositoryI blogRepositoryI;


    protected BlogMapper blogMapper;

    @Override
    public List<BlogDto> getAll() {
        return blogRepositoryI.findAll()
                .stream()
                .map(this.blogMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @PreAuthorize("hasAnyRole('ROLE_SUPERUSER', 'ROLE_USER')")
    public Blog addBlog(String text) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Blog blog = new Blog();
        blog.setText(text);
        blog.setUser_id(((UserPrincipal) principal).getId());
        blogRepositoryI.save(blog);
        return blog;
    }

    @Override
    @PreAuthorize("hasRole('ROLE_SUPERUSER')")
    public void delete(Long id) {
        if (!blogRepositoryI.existsById(id)) {
            throw new UsernameNotFoundException("No blog found");
        }
        blogRepositoryI.deleteById(id);

    }
}
