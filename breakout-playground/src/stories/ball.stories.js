import React from 'react';

import { storiesOf } from '@storybook/react';

import Ball from '../js/component/atom/Ball';

storiesOf('Atom/Ball', module)
    .add('default', () => <Ball/>);
