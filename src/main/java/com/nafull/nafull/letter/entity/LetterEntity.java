package com.nafull.nafull.letter.entity;

import com.nafull.nafull.letter.data.BadgeType;
import com.nafull.nafull.letter.data.SendLetter;
import com.nafull.nafull.letter.data.Letter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

import static com.nafull.nafull.letter.data.Letter.LOCKED_CONTENT;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LetterEntity {
    @Id
    private UUID letterId;

    private UUID senderId;

    private String receiverDiscordId;

    private String nickname;

    private String content;

    private BadgeType badge;

    private Boolean locked;

    public static LetterEntity from(SendLetter wish) {
        return new LetterEntity(
            UUID.randomUUID(),
            wish.senderId(),
            wish.receiverDiscordId(),
            wish.senderNickname(),
            wish.content(),
            wish.badge(),
            true
        );
    }

    public Letter toDomainWithContentLock() {
        return new Letter(
            letterId,
            senderId,
            receiverDiscordId,
            nickname,
            locked ? LOCKED_CONTENT : content,
            badge,
            locked
        );
    }
}
