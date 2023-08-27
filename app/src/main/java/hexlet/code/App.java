package hexlet.code;

import io.javalin.Javalin;
//import io.javalin.plugin.rendering.template.JavalinThymeleaf;
//import io.javalin.rendering.template.JavalinThymeleaf;
//import static io.javalin.apibuilder.ApiBuilder.path;
//import static io.javalin.apibuilder.ApiBuilder.get;
//import static io.javalin.apibuilder.ApiBuilder.post;
//
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
//import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
//import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;


public class App {
    public static Javalin getApp() {
        Javalin app = Javalin.create(config -> {
            if (!isProduction()) {
                config.plugins.enableDevLogging();
            }
//            config.enableWebjars();
//            JavalinThymeleaf.configure(getTemplateEngine());
        });

//        addRoutes(app);

        app.before(ctx -> {
            ctx.attribute("ctx", ctx);
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
//        app.start(getPort());
//        Javalin.create(config -> {
//            config.plugins.enableDevLogging();
//        });
        app.get("/", ctx -> ctx.result("Hello World"));
        app.start(7070);
    }

    private static String getMode() {
        return System.getenv().getOrDefault("APP_ENV", "development");
    }

    private static boolean isProduction() {
        return getMode().equals("production");
    }

//    private static TemplateEngine getTemplateEngine() {
//        TemplateEngine templateEngine = new TemplateEngine();
//
//        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//        templateResolver.setPrefix("/templates/");
//
//        templateResolver.setCharacterEncoding("UTF-8");
//
//        templateEngine.addTemplateResolver(templateResolver);
//        templateEngine.addDialect(new LayoutDialect());
//        templateEngine.addDialect(new Java8TimeDialect());
//
//        return templateEngine;
//    }
}
