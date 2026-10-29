# 🛒 E-Commerce Spring Boot API

API REST desenvolvida em **Java** com o ecossistema **Spring Boot 3** e **Spring Data JPA**, simulando o fluxo de compras de um e-commerce com gerenciamento de **Clientes**, **Produtos**, **Pedidos** e **Pagamentos**.

> 📖 **Quer entender a lógica a fundo?**  
> Acesse o guia detalhado com diagramas e regras de negócio em:  
> 🔗 [**`docs/ARQUITETURA_E_RELACIONAMENTOS.md`**](docs/ARQUITETURA_E_RELACIONAMENTOS.md)

---

## 🛠️ Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3**
* **Spring Data JPA / Hibernate** (Mapeamento Objeto-Relacional)
* **PostgreSQL / H2 Database**
* **Lombok** (Produtividade e redução de boilerplate)
* **Maven Wrapper**

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
* Java JDK 21 instalado
* Maven (opcional, pois o projeto inclui o wrapper `mvnw`)

### Passo a Passo

1. **Clone o seu repositório:**
   ```bash
   git clone https://github.com/Richdssz/springbootAula.git
   cd springbootAula
   ```

2. **Execute a aplicação via terminal:**
   * No Windows:
     ```powershell
     .\mvnw.cmd spring-boot:run
     ```
   * No Linux / macOS:
     ```bash
     ./mvnw spring-boot:run
     ```

3. **Acesse a API:**
   * Servidor local: `http://localhost:8080`

---

## 📡 Endpoints da API

### 👤 Clientes (`/api/v1/cliente`)
| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/novoCliente` | Cadastra um novo cliente |
| `GET` | `/all` | Lista todos os clientes |
| `GET` | `/cliente/{id}` | Busca cliente por ID |
| `DELETE` | `/cliente/{id}` | Remove cliente por ID |

### 📦 Produtos (`/api/v1/produto`)
| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/novoProduto` | Cadastra um novo produto |
| `GET` | `/all` | Lista todos os produtos |
| `GET` | `/{id}` | Busca produto por ID |
| `DELETE` | `/{id}` | Remove produto |

### 🛍️ Pedidos (`/api/v1/pedido`)
| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `?clienteId={id}&produtosIds=1,2` | Cria pedido vinculado a cliente e produtos |
| `GET` | `/all` | Lista todos os pedidos |
| `GET` | `/{id}` | Busca pedido por ID |
| `PATCH` | `/{id}/status?status=CONCLUIDO` | Altera status do pedido |

### 💳 Pagamentos (`/api/v1/pagamento`)
| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `?pedidoId={id}&valor=99.90&metodo=PIX` | Processa pagamento de um pedido |
| `GET` | `/pedido/{pedidoId}` | Consulta pagamento do pedido |
| `PATCH` | `/{id}/status?status=APROVADO` | Atualiza status da transação |

---

## 🔄 Sincronizando com o Repositório do Professor (Upstream)

Para baixar novas aulas e atualizações lançadas no repositório original do professor:

```bash
# 1. Puxe as atualizações do professor
git pull upstream main

# 2. Envie as atualizações para o seu repositório pessoal
git push origin main
```

---

## 📄 Licença
Projeto acadêmico para a disciplina de Programação Orientada a Objetos (POO) - UNICAP.
