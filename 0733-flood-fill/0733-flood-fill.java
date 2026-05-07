class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        if (image[sr][sc] == color) return image;

        boolean[][] vis = new boolean[n][m];
        dfs(image, sr, sc, color, image[sr][sc], vis);

        return image;
    }

    void dfs(int[][] img, int i, int j, int newc, int oc, boolean[][] vis) {
        int n = img.length;
        int m = img[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || img[i][j] != oc) {
            return;
        }

        vis[i][j] = true;
        img[i][j] = newc;

        dfs(img, i + 1, j, newc, oc, vis);
        dfs(img, i - 1, j, newc, oc, vis);
        dfs(img, i, j + 1, newc, oc, vis);
        dfs(img, i, j - 1, newc, oc, vis);
    }
}