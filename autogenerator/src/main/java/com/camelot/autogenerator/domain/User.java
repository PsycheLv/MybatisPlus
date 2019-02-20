package com.camelot.autogenerator.domain;

import com.camelot.autogenerator.common.domain.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lyp
 * @since 2019-02-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User extends BaseDomain {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private Long telephone;


}
