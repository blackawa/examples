import React from 'react';

import { storiesOf } from '@storybook/react';

import Block from '../js/component/atom/Block';

storiesOf('Block', module)
    .add('default', () => <Block>Block</Block>);
