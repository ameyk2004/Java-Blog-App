package com.ameyTech.blog.mappers;

import com.ameyTech.blog.domain.PostStatus;
import com.ameyTech.blog.domain.dto.CategoryDto;
import com.ameyTech.blog.domain.dto.CreateCategoryRequest;
import com.ameyTech.blog.domain.model.Category;
import com.ameyTech.blog.domain.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Named("caclulatePostCount")
    default long caclulatePostCount(List<Post> posts){
        if(posts==null){
            return 0;
        }

        return posts.stream()
                .filter(post -> post.getStatus().equals(PostStatus.PUBLISHED)).count();
    }


    Category toEntity(CreateCategoryRequest createCategoryRequest);

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "caclulatePostCount")
    CategoryDto toDto(Category category);
}
