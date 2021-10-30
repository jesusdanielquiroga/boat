package com.boat.model.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jquiroga
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusAmount {
    private int completed;
    private int cancelled;
}
