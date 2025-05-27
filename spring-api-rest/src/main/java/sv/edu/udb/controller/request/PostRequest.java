package sv.edu.udb.controller.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    @FutureOrPresent
    private LocalDate postDate;
}
