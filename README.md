# ZeroGen

ZeroGen 是一个企业级 AI 代码生成与自动化部署平台，旨在通过大语言模型（LLM）实现从自然语言描述到可运行前端应用的端到端转化。系统集成了代码生成、工程化构建、流式交互及一键部署等核心功能，支持单文件 HTML 到复杂 Vue 3 工程的自动化产出。

##  核心架构

项目采用模块化设计，确保了 AI 生成能力与业务逻辑的解耦：

- **AI 编排层 (Orchestration)**: 基于 LangChain4j 与 LangGraph4j 构建，支持多模型切换（OpenAI, Aliyun DashScope）及 Tool Call（工具调用）扩展。
- **生成引擎 (Generation Engine)**:
    - **Parser**: 负责将 LLM 输出的原始文本或 JSON 转换为结构化代码对象。
    - **Saver**: 支持本地文件系统持久化，根据生成类型（HTML/Vue）自动组织目录结构。
    - **Builder**: 集成基于 Java 21 虚拟线程的异步构建系统，支持自动化执行 `npm install` 与 `npm run build`。
- **交互层 (Communication)**: 采用 SSE (Server-Sent Events) 实现流式响应，配合自定义 `StreamHandler` 实时处理 Token 流与工具执行状态。

## 🚀 关键技术特性

### 1. 混合生成模式
- **轻量级模式**: 生成单文件 HTML 或 CSS/JS 分离的多文件结构，适用于快速原型。
- **工程化模式**: 自动初始化完整的 Vue 3 + Vite + TypeScript 项目，通过 Tool Call 实时写入多层级文件。

### 2. 自动化流水线
系统不仅生成代码，还涵盖了完整的交付链路：
- **依赖分析**: 自动生成符合规范的 `package.json`。
- **异步构建**: 后端启动独立进程完成前端构建，并实时校验 `dist` 产物。
- **动态部署**: 基于生成路径的静态资源映射，支持生成唯一的部署 Key 并实时预览。

### 3. 对话上下文管理
集成 RedisChatMemoryStore 与 Caffeine 本地缓存，结合 `MessageWindowChatMemory` 实现长对话记忆，支持用户基于已有生成的迭代优化。

## 🛠️ 技术栈详情

### 后端核心
- **运行时**: Java 21 (利用虚拟线程优化构建并发)
- **框架**: Spring Boot 3.5.x, Spring AOP, Spring Session
- **AI 组件**: LangChain4j 1.1.x, LangGraph4j 1.6.x
- **持久层**: MyBatis-Flex (极简 CRUD 与 联表查询)
- **存储与并发**: MySQL 8.0, Redis (Redisson), Caffeine
- **自动化**: Selenium (自动化截图校验), Node.js Runtime (构建支撑)

### 前端架构
- **核心**: Vue 3 (Composition API), Vite, TypeScript
- **状态**: Pinia
- **UI**: Ant Design Vue 4.x
- **交互**: Markdown-it (实时代码高亮与渲染预览)

##  项目目录导航

```text
├── sql/                         # 数据库结构与初始化数据
├── src/main/java/com/yuanc/
│   ├── ai/                      # AI 接口定义、模型配置及自定义 Tool
│   ├── core/                    # 核心逻辑：Facade 模式封装、代码解析与保存
│   │   ├── builder/             # Vue 项目异步构建流水线
│   │   ├── handler/             # SSE 流式消息拦截与处理
│   │   └── saver/               # 多策略文件持久化实现
│   ├── controller/              # RESTful API 接口
│   └── service/                 # 核心业务逻辑
├── src/main/resources/
│   └── prompt/                  # 各模式系统提示词 (System Prompt) 模板
└── yuan-ai-code-mother-frontend # 基于 Vue 3 的管理与生成前端
```

## 🏁 快速部署指南

### 环境准备
- **JDK 21**: 必须版本，以支持虚拟线程。
- **Node.js 18+**: 后端构建 Vue 项目及前端开发必备。
- **MySQL & Redis**: 确保服务可用并配置正确。

### 配置与运行
1. **数据库配置**: 执行 `sql/create_table.sql`。
2. **应用配置**: 修改 `application.yml` 中的 `spring.datasource`、`spring.data.redis` 及 AI 相关配置（如 `apiKey`）。
3. **后端启动**: 运行 `YuanAiCodeMotherApplication`。
4. **前端启动**:
   ```bash
   cd yuan-ai-code-mother-frontend
   npm install
   npm run dev
   ```

## 📜 许可证
本项目基于 MIT 协议开源。
