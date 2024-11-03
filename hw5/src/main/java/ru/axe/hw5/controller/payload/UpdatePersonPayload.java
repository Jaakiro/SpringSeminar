package ru.axe.hw5.controller.payload;

public record UpdatePersonPayload(
        Integer id, String name, Integer age) {
}
