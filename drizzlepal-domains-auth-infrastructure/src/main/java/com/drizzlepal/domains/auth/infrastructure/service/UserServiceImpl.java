package com.drizzlepal.domains.auth.infrastructure.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.drizzlepal.domains.auth.api.UserApi;
import com.drizzlepal.domains.auth.api.dto.request.CreateUserRequest;
import com.drizzlepal.domains.auth.api.dto.request.DeleteUserRequest;
import com.drizzlepal.domains.auth.api.dto.request.GetUserByUsernameRequest;
import com.drizzlepal.domains.auth.api.dto.request.GetUserPageRequest;
import com.drizzlepal.domains.auth.api.dto.request.GetUserRequest;
import com.drizzlepal.domains.auth.api.dto.request.UpdateUserRequest;
import com.drizzlepal.domains.auth.api.dto.response.CreateUserResponse;
import com.drizzlepal.domains.auth.api.dto.response.GetUserPageResponse;
import com.drizzlepal.domains.auth.api.dto.response.GetUserResponse;
import com.drizzlepal.domains.auth.api.dto.response.UpdateUserResponse;
import com.drizzlepal.domains.auth.domain.model.User;
import com.drizzlepal.domains.auth.domain.repository.UserRepository;

@Service
public class UserServiceImpl implements UserApi {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreateUserResponse createUser(CreateUserRequest request) {
        User user = User.builder()
                .id(UUID.randomUUID().toString())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .roleId(request.getRoleId())
                .status(request.getStatus())
                .createTime(new Date())
                .updateTime(new Date())
                .build();
        userRepository.create(user);
        return CreateUserResponse.builder().userId(user.getId()).build();
    }

    @Override
    public GetUserResponse getUser(GetUserRequest request) {
        Optional<User> user = userRepository.findById(request.getId());
        if (user.isEmpty()) {
            return null;
        }
        User u = user.get();
        return GetUserResponse.builder()
                .id(u.getId())
                .username(u.getUsername())
                .email(u.getEmail())
                .roleId(u.getRoleId())
                .status(u.getStatus())
                .createTime(u.getCreateTime())
                .updateTime(u.getUpdateTime())
                .build();
    }

    @Override
    public GetUserResponse getUserByUsername(GetUserByUsernameRequest request) {
        Optional<User> user = userRepository.findUserNotDeletedByUsername(request.getUsername());
        if (user.isEmpty()) {
            return null;
        }
        User u = user.get();
        return GetUserResponse.builder()
                .id(u.getId())
                .username(u.getUsername())
                .email(u.getEmail())
                .roleId(u.getRoleId())
                .status(u.getStatus())
                .createTime(u.getCreateTime())
                .updateTime(u.getUpdateTime())
                .build();
    }

    @Override
    public UpdateUserResponse updateUser(UpdateUserRequest request) {
        Optional<User> existingOpt = userRepository.findById(request.getId());
        if (existingOpt.isEmpty()) {
            return null;
        }
        User existing = existingOpt.get();
        User updated = User.builder()
                .id(existing.getId())
                .username(request.getUsername() != null ? request.getUsername() : existing.getUsername())
                .email(request.getEmail() != null ? request.getEmail() : existing.getEmail())
                .password(request.getPassword() != null ? request.getPassword() : existing.getPassword())
                .roleId(request.getRoleId() != null ? request.getRoleId() : existing.getRoleId())
                .status(request.getStatus() != null ? request.getStatus() : existing.getStatus())
                .createTime(existing.getCreateTime())
                .updateTime(new Date())
                .build();
        userRepository.update(updated);
        return UpdateUserResponse.builder()
                .id(updated.getId())
                .username(updated.getUsername())
                .email(updated.getEmail())
                .roleId(updated.getRoleId())
                .status(updated.getStatus())
                .createTime(updated.getCreateTime())
                .updateTime(updated.getUpdateTime())
                .build();
    }

    @Override
    public void deleteUser(DeleteUserRequest request) {
        userRepository.delete(request.getId());
    }

    @Override
    public GetUserPageResponse getUserPage(GetUserPageRequest request) {
        List<User> allUsers = userRepository.findAll();
        
        // Filter by keyword
        if (request.getKeyword() != null && !request.getKeyword().isEmpty()) {
            String keyword = request.getKeyword().toLowerCase();
            allUsers = allUsers.stream()
                    .filter(u -> u.getUsername().toLowerCase().contains(keyword) 
                            || (u.getEmail() != null && u.getEmail().toLowerCase().contains(keyword)))
                    .collect(Collectors.toList());
        }
        
        // Filter by roleId
        if (request.getRoleId() != null && !request.getRoleId().isEmpty()) {
            allUsers = allUsers.stream()
                    .filter(u -> request.getRoleId().equals(u.getRoleId()))
                    .collect(Collectors.toList());
        }
        
        // Filter by status
        if (request.getStatus() != null && !request.getStatus().isEmpty()) {
            allUsers = allUsers.stream()
                    .filter(u -> request.getStatus().equals(u.getStatus()))
                    .collect(Collectors.toList());
        }
        
        long total = allUsers.size();
        
        // Pagination
        int pageNum = request.getPageNum() != null ? request.getPageNum() : 1;
        int pageSize = request.getPageSize() != null ? request.getPageSize() : 10;
        int start = (pageNum - 1) * pageSize;
        int end = Math.min(start + pageSize, allUsers.size());
        
        List<User> pagedUsers = start < allUsers.size() ? allUsers.subList(start, end) : List.of();
        
        List<GetUserResponse> records = pagedUsers.stream()
                .map(u -> GetUserResponse.builder()
                        .id(u.getId())
                        .username(u.getUsername())
                        .email(u.getEmail())
                        .roleId(u.getRoleId())
                        .status(u.getStatus())
                        .createTime(u.getCreateTime())
                        .updateTime(u.getUpdateTime())
                        .build())
                .collect(Collectors.toList());
        
        return GetUserPageResponse.builder()
                .records(records)
                .total(total)
                .pageNum(pageNum)
                .pageSize(pageSize)
                .build();
    }
}
