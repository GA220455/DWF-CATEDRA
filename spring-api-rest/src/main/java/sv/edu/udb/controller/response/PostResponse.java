package sv.edu.udb.controller.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDate postDate;
}
