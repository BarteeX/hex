package com.review.adapter.event.mapper;

import com.review.application.ValueObjectMapper;
import com.review.application.command.NewAuthenticateUserCreatedCommand;
import com.review.application.command.NewAuthenticateUserCreatedFailureCommand;
import com.review.application.command.NewUserCreatedCommand;
import com.review.application.command.NewUserCreatedFailureCommand;
import com.review.events.CreateUserAuthenticationFailureEvent;
import com.review.events.CreateUserAuthenticationSuccessEvent;
import com.review.events.CreateUserFailureEvent;
import com.review.events.CreateUserSuccessEvent;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
      componentModel = SPRING,
      uses = {
            ValueObjectMapper.class
      }
)
public interface UserAuthenticationEventMapper {

    NewUserCreatedCommand toCommand(CreateUserSuccessEvent event);

    NewUserCreatedFailureCommand toCommand(CreateUserFailureEvent event);

    NewAuthenticateUserCreatedCommand toCommand(CreateUserAuthenticationSuccessEvent event);

    NewAuthenticateUserCreatedFailureCommand toCommand(CreateUserAuthenticationFailureEvent event);

}
