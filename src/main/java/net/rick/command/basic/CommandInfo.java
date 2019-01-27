package net.rick.command.basic;

import net.dv8tion.jda.core.Permission;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
public @interface CommandInfo {
    String name();

    String usage() default "";

    String description() default "brak opisu.";

    CommandCategory category() default CommandCategory.NONE;

    Permission[] permissions();

    String[] aliases() default "";
}