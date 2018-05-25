import React from 'react';
import {storiesOf} from '@storybook/react';
import Button from "../../src/components/presentations/atoms/Button";

storiesOf('atoms/Button', module)
    .add('default', () => <Button label='ラベル'/>);