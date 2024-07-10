package dev.daniyar.posts.postCont;

public record Post(Integer id,
                   Integer userId,
                   String title,
                   String body,
                   Integer version) {
}
