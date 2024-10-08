import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import path from 'path'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  resolve: {
    alias: {
      pages: path.resolve('src/pages/index'),
      shared: path.resolve('src/shared/index'),
    },
  },
})
