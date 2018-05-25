import React from 'react';
import {storiesOf} from '@storybook/react';
import TextField from "../../src/components/presentations/atoms/TextField";

storiesOf('atoms/TextField', module)
    .add('default', () => <TextField placeholder='プレースホルダー'/>);