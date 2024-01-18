package com.study.todoapi.todo.service;

import com.study.todoapi.todo.dto.request.TodoCreateRequestDTO;
import com.study.todoapi.todo.dto.response.TodoDetailResponseDTO;
import com.study.todoapi.todo.dto.response.TodoListResponseDTO;
import com.study.todoapi.todo.entity.Todo;
import com.study.todoapi.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional // jpa 사용시 필수
public class TodoService {
    private final TodoRepository todoRepository;

    //할 일 등록
    public TodoListResponseDTO create(TodoCreateRequestDTO dto){
        todoRepository.save(dto.toEntity());
        log.info("새로운 할 일이 저장되었습니다. 제목 : {}", dto.getTitle());

        return retrieve();
    }

    //할 일 몰록 불러오기
    public TodoListResponseDTO retrieve() {

        List<Todo> todoList = todoRepository.findAll();

        List<TodoDetailResponseDTO> dtoList = todoList.stream()
                .map(todo -> new TodoDetailResponseDTO(todo))
                .collect(Collectors.toList());

        return TodoListResponseDTO.builder()
                .todos(dtoList)
                .build();
    }
}
