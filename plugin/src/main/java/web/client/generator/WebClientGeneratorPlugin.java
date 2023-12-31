/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package web.client.generator;

import org.gradle.api.Project;
import org.gradle.api.tasks.JavaExec;
import org.gradle.api.Plugin;
import org.gradle.api.tasks.TaskContainer;

/**
 * A simple 'hello world' plugin.
 */
public class WebClientGeneratorPlugin implements Plugin<Project> {
    public void apply(Project project) {
        TaskContainer tasks = project.getTasks();

        tasks.register("greeting", task -> {
            task.doLast(s -> System.out.println("Hello from plugin 'web.client.generator.greeting'"));
        });
        tasks.register("hell", task -> {
            task.doLast(s -> System.out.println("Hell from plugin 'web.client.generator.greeting'"));
        });
        tasks.register("generateCode", JavaExec.class, generateCode -> {
            generateCode.getMainClass().set("org.openapitools.codegen.OpenAPIGenerator");
            generateCode.setClasspath(project.getConfigurations().getByName("implementation"));
            generateCode.args("generate",
                    "-g", "spring",
                    "-i", "path/to/swagger.json", // 替换为您的 Swagger.json 文件路径
                    "-o", "path/to/output", // 替换为生成代码的输出路径
                    "--additional-properties", "useOptional=true"); // 根据需要添加其他参数
        });
    }
}
