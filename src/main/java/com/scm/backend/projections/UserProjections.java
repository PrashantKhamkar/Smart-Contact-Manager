package com.scm.backend.projections;


import com.scm.backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.rest.core.config.Projection;


@Projection(name = "user-projection",types = {User.class})
public interface UserProjections
{
    String getName();

    String getEmail();

    String getAbout();
}
