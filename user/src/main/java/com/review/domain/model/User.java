package com.review.domain.model;


import com.review.domain.FirstName;
import com.review.domain.LastName;
import com.review.domain.UserId;
import com.review.domain.Username;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    private UserId id;

    private Username username;

    private FirstName firstName;

    private LastName lastName;

}
