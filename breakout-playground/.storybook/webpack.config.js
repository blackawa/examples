const defaultConfig = require('../webpack.config');

module.exports = (config) => {
  config.module.rules = defaultConfig.module.rules;
  return config;
};