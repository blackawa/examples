import React from 'react';
import {storiesOf} from '@storybook/react';
import {action} from '@storybook/addon-actions';
import Button from '../js/component/Button';

storiesOf('Button', module)
    .add('with text', () => (
      <Button onClick={action('clicked')}>Hello button</Button>
    ))
    .add('with emoji', () => (
      <Button onClick={action('clicked')}>🍣</Button>
    ));