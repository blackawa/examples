import {configure} from '@storybook/react';

function loadStories() {
  require('../src/js/story/index.js');
}

configure(loadStories, module);