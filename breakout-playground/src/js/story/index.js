import React from 'react';
import {storiesOf} from '@storybook/react';
import {linkTo} from '@storybook/addon-links';
import Button from '../component/Button';
import Block from '../component/atom/Block';

storiesOf('Button', module)
    .add('First', () => (
        <Button onClick={linkTo('Button', 'Second')}>Hello button</Button>
    ))
    .add('Second', () => (
        <Button onClick={linkTo('Button')}>🍣</Button>
    ));

storiesOf('Block', module)
    .add('First', () => (
      <Block/>
    ));