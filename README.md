# 📂 Lectura de CSV en Java 17

## 1. 📝 Introducción

Este repositorio tiene por finalidad la lectura de un archivo CSV haciendo uso de **Java 17**, aplicando buenas prácticas de programación como:

- ✅ Encapsulamiento  
- ✅ Inmutabilidad  
- ✅ Separación de responsabilidades  
- ✅ Manejo de excepciones  
- ✅ Uso de tipos adecuados de datos para operaciones financieras (`BigDecimal`)

Se utilizaron bibliotecas estándar de Java:

- `java.io`
- `java.math`
- `java.util`

Además, se empleó **JavaDoc** para la generación de documentación del código.

> 💡 **Nota**: Para hacer uso de JavaDoc con Maven, se debe agregar el siguiente plugin en el archivo `pom.xml`:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-javadoc-plugin</artifactId>
            <version>3.5.0</version>
            <executions>
                <execution>
                    <id>attach-javadocs</id>
                    <goals>
                        <goal>jar</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```
## 2. ▶️ Instrucciones de Ejecución
### Requisitos Previos
* Java 17 instalado
* Maven instalado

### Pasos para ejecutar la aplicación
#### 1. Clonar el repositorio:

#### usando bash o cmd:
```
git clone https://github.com/tu_usuario/tu_repositorio.git
cd tu_repositorio
```
#### 2. Configurar la ejecución:
Editar la configuración de ejecución del método main, agregando la ruta **absoluta del archivo CSV** como argumento del programa.

Ejecutar la aplicación desde tu IDE o desde consola con:

#### usando bash o cmd:
mvn compile exec:java

Para la generación de documentación con JavaDoc:
#### usando bash o cmd:
mvn javadoc:doc

## 3. ⚙️ Enfoque y Solución
El proyecto fue desarrollado bajo una arquitectura en capas, respetando los principios SOLID y aplicando los siguientes patrones de diseño:
* Repository Pattern.
* DTO Pattern

El sistema de construcción utilizado fue Apache Maven, permitiendo una gestión eficiente de dependencias y compilación.

##4. 🗂️ Estructura del Proyecto

```
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/
│   │   │       └── transacciones_bancarias/
│   │   │           ├── application/
│   │   │           │   ├── dto/                         # Clases de transferencia de datos (DTOs)
│   │   │           │   │   └── TransactionReport.java
│   │   │           │   └── service/                     # Lógica de negocio
│   │   │           │       └── TransactionService.java
│   │   │           ├── domain/
│   │   │           │   ├── exception/                   # Clases para manejo de excepciones personalizadas
│   │   │           │   │   └── ProcessingException.java
│   │   │           │   └── model/                       # Entidades del dominio
│   │   │           │       ├── Transaction.java
│   │   │           │       └── TransactionType.java
│   │   │           ├── infrastructure/
│   │   │           │   └── repository/                  # Implementaciones de acceso a datos
│   │   │           │       └── CsvTransactionRepository.java
│   │   │           ├── util/                            # Clases utilitarias
│   │   │           │   └── CsvParser.java
│   │   │           └── presentation/
│   │   │               └── console/                     # Presentación por consola
│   │   │                   ├── ConsoleReportAppearance.java
│   │   │                   └── Main.java                # Punto de entrada del programa
│   └── resources/                                       # Archivos de recursos (como CSVs)
├── test/                                                # Clases de prueba unitaria
├── pom.xml                                              # Configuración de Maven y dependencias
└── README.md                                            # Documentación del proyecto

```

