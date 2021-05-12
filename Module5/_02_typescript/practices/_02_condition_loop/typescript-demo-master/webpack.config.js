const webpack = require("webpack");
const path = require("path");
const HtmlWebpackPlugin = require("html-webpack-plugin");
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const nodeEnv = process.env.NODE_ENV || "development";
const isProd = nodeEnv === "production";

const plugins = [
  new webpack.DefinePlugin({
    "process.env": {
      NODE_ENV: JSON.stringify(nodeEnv)
    }
  }),
  new HtmlWebpackPlugin({
    title: "Typescript Fundamentals",
    template: "!!ejs-loader!src/index.html",
    chunks: ['app']
  }),
  new HtmlWebpackPlugin({
    title: "Typescript Fundamentals",
    template: "!!ejs-loader!src/fundamentals.html",
    chunks: ["fundamentals"],
    filename: "./fundamentals.html"
  }),
  new HtmlWebpackPlugin({
    title: "Typescript Control Flow",
    template: "!!ejs-loader!src/control-flow.html",
    chunks: ["controlFlow"],
    filename: "./control-flow.html"
  }),
  new HtmlWebpackPlugin({
    title: "Typescript Array",
    template: "!!ejs-loader!src/array.html",
    chunks: ["array"],
    filename: "./array.html"
  }),
  new HtmlWebpackPlugin({
    title: "Typescript Function",
    template: "!!ejs-loader!src/functions.html",
    chunks: ["functions"],
    filename: "./functions.html"
  }),
  new HtmlWebpackPlugin({
    title: "Typescript Object",
    template: "!!ejs-loader!src/object.html",
    chunks: ["object"],
    filename: "./object.html"
  }),
  new HtmlWebpackPlugin({
    title: "Typescript Promise",
    template: "!!ejs-loader!src/promise.html",
    chunks: ["promise"],
    filename: "./promise.html"
  }),
  new HtmlWebpackPlugin({
    title: "Typescript Exercise",
    template: "!!ejs-loader!src/exercise/index.html",
    chunks: ["exercise"],
    filename: "./exercise/index.html"
  }),
  new webpack.LoaderOptionsPlugin({
    options: {
      tslint: {
        emitErrors: true,
        failOnHint: true
      }
    }
  }),
  new MiniCssExtractPlugin({
    filename: isProd ? "[name].[hash].css" : "[name].css",
    chunkFilename: isProd ? "[id].[hash].css" : "[id].css"
  })
];

const config = {
  devtool: isProd ? false : "source-map",
  context: path.resolve("./src"),
  entry: {
    app: "./index.ts",
    fundamentals: "./fundamentals.ts",
    controlFlow: "./control-flow.ts",
    array: "./array.ts",
    functions: "./functions.ts",
    object: "./object.ts",
    promise: "./promise.ts",
    exercise: "./exercise/index.ts",
  },
  output: {
    path: path.resolve("./dist"),
    filename: "[name].bundle.js"
  },
  module: {
    rules: [
      {
        test: /\.ts?$/,
        exclude: /node_modules/,
        use: ["awesome-typescript-loader", "source-map-loader"]
      },
      { test: /\.html$/, loader: "html-loader" },
      {
        test: /\.(sa|sc|c)ss$/,
        use: [
          isProd ? MiniCssExtractPlugin.loader : "style-loader",
          "css-loader",
          "sass-loader"
        ]
      }
    ].filter(Boolean)
  },
  resolve: {
    extensions: [".ts", ".js"]
  },
  plugins: plugins,
  devServer: {
    contentBase: path.join(__dirname, "src/"),
    compress: true,
    port: 3000,
    hot: true,
    watchContentBase: true
  }
};

module.exports = config;
