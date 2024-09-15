import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import path from 'path'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  resolve: {
    alias: {
      api: path.resolve('src/shared/api/index'),
      httpt: path.resolve('src/shared/httptransport/HTTPTransport'),
      pages: path.resolve('src/pages/index'),
      store: path.resolve('src/shared/store/store'),
      constant: path.resolve('src/shared/constant/index'),
    },
  },
})
