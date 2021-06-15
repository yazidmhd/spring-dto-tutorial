package com.dtotutorial.dto.mapstruct.mappers;

import com.dtotutorial.dto.entity.Author;
import com.dtotutorial.dto.entity.Book;
import com.dtotutorial.dto.entity.User;
import com.dtotutorial.dto.mapstruct.dtos.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
    BookSlimDto bookToBookSlimDto(Book book);

    BookDto booktoBookDto(Book book);

    AuthorDto authorToAuthorDto(Author author);

    AuthorAllDto authorToAuthorAllDto(Author author);

    List<AuthorAllDto> authorsToAuthorAllDtos(List<Author> authors);

    UserGetDto userToUserGetDto(User user);

    User userPostDtoToUser(UserPostDto userPostDto);

    UserPostDto userToUserPostDto

    //UserGetDto userPostDtoToUserGetDto(UserPostDto userPostDto);
}
