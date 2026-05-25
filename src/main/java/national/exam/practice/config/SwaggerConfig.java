package national.exam.practice.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot API with JWT Security")
                        .version("1.0")
                        .description("""
                                ## How to test JWT in Swagger (PostgreSQL)
                                
                                Users are stored in the **users** table. Either:
                                - Run `db/seed-users.sql` in your `exeta` database, or
                                - Call **POST /api/auth/register** to create a user (saved to PostgreSQL)
                                
                                Then:
                                1. **POST /api/auth/login** with an email/password from the database
                                2. Copy `accessToken` from the response
                                3. Click **Authorize** and paste the token
                                4. Call **GET /api/users/me** to verify JWT access
                                5. **GET /api/users** (ADMIN) — paginated list: `?page=0&size=10&sort=email,asc`
                                """)
                        .contact(new Contact()
                                .name("Support")
                                .email("support@example.com")
                                .url("https://example.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .description("Paste the accessToken from login/register")));
    }
}
