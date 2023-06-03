package Samsung.service.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    식비("식비"),교통비("교통비"),보험비("보험비"),주거비("주거비"),구독비("구독비");

    private final String name;
}
