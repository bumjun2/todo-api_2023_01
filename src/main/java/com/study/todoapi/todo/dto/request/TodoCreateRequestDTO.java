package com.study.todoapi.todo.dto.request;

import com.study.todoapi.todo.entity.Todo;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter @Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoCreateRequestDTO {

    @NotBlank
    @Size(min = 2, max = 10)
    private String title;

    public Todo toEntity(){
        return Todo.builder()
                .title(this.title)
                .build();
    }
}
