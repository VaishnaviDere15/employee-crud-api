# Employee Management System (Spring Boot)

This is a CRUD-based web application built using **Spring Boot** to manage employee records. It demonstrates real-world use of Spring Boot concepts including REST APIs, Spring Data JPA, Thymeleaf, and Spring Security.

---

## 🚀 Features

- Create, Read, Update, Delete (CRUD) Employees
- RESTful APIs for backend operations
- Thymeleaf-powered frontend
- Spring Security with in-memory and JDBC-based authentication
- Pagination with Bootstrap UI
- Role-based access (ADMIN / USER)
- DTO & MapStruct for cleaner data transfer
- Global Exception Handling using `@ControllerAdvice`
- H2 in-memory database (for development/testing)
- Swagger/OpenAPI 3 documentation
- Validation using `@Valid` and JSR-380 annotations
- Lombok to reduce boilerplate code

---

## 🛠️ Technologies Used

| Layer        | Technology        |
|--------------|-------------------|
| Backend      | Spring Boot 2.7.10 |
| Web Layer    | Spring MVC, Thymeleaf |
| Security     | Spring Security (`formLogin`, roles) |
| ORM          | Spring Data JPA (Hibernate) |
| DB           | H2 (runtime) |
| Build Tool   | Maven |
| Documentation| Springdoc OpenAPI Swagger UI |
| Utility      | MapStruct, Lombok |

---

## 🧩 Spring Boot Concepts Covered

- `@RestController`, `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`
- `@Service`, `@Repository`, `@Autowired`, `@Component`
- JPA Repositories: `CrudRepository`, `JpaRepository`
- Custom Query Methods (`@Query`)
- `@Entity`, `@Id`, `@GeneratedValue`, `@OneToMany`, `@ManyToOne`
- DTO Mapping using MapStruct
- `@Valid`, `@NotBlank`, `@Email` validations
- `@ControllerAdvice` for global exception handling
- `@Configuration`, `@EnableMethodSecurity`
- `@PreAuthorize` for method-level access
- Swagger UI with `/swagger-ui.html` or `/swagger-ui/index.html`
- Profiles and DevTools for fast reload

---

## 🔐 Default Users

| Username | Password | Role  |
|----------|----------|-------|
| admin    | admin123 | ADMIN |
| user     | user123  | USER  |

---

## 🧪 How to Run

1. Clone this repo:
   ```bash
   git clone https://github.com/VaishnaviDere15/employee-crud-api.git
