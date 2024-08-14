package ru.job4j.lombok;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class Category {
    @NonNull
    @EqualsAndHashCode.Include
    private Integer id;

    @Setter
    private String name;
}
