/**
 * 环境变量配置
 */

// 应用部署域名
export const DEPLOY_DOMAIN = import.meta.env.VITE_DEPLOY_DOMAIN || 'http://localhost'

// API 基础地址
export const API_BASE_URL = import.meta.env.VITE_API_BASE_URL || 'http://localhost:8123/api'

// 静态资源地址
export const STATIC_BASE_URL = `${API_BASE_URL}/static`

// 获取部署应用的完整URL
export const getDeployUrl = (deployKey: string) => {
  return `${DEPLOY_DOMAIN}/${deployKey}`
}

// 获取静态资源预览URL
export const getStaticPreviewUrl = (codeGenType: string, appId: string) => {
  const projectRoot = `${STATIC_BASE_URL}/${codeGenType}_${appId}`
  if (codeGenType === 'vue_project') {
    // Vue 项目预览应指向构建产物目录，避免直接访问源码目录导致页面渲染异常
    return `${projectRoot}/dist/`
  }
  return `${projectRoot}/`
}
