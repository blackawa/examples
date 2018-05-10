import {configure} from '@storybook/react';

function loadStories() {
  require('../src/story/index.js');
}

configure(loadStories, module);