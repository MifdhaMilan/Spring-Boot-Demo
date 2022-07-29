package com.sun.travels.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProfileToStudent {
    private int studentId;
    private int profileId;
}
