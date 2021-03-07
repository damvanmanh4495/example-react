import React from 'react';
import PropTypes from 'prop-types';

CategoryItem.propTypes = {
    onClickShow: PropTypes.func,
};
CategoryItem.defaultProps = {
    onClickShow: null
}
interface Props {
    name: string | undefined,
    onClickShow: any
}
function CategoryItem(props: Props) {
    const { onClickShow } = props;
    const handleShow = () => {
        if (onClickShow) {
            onClickShow();
        }
    }
    return (
        <li className="item-category" onClick={handleShow}>{props.name}</li>
    );
}

export default CategoryItem;