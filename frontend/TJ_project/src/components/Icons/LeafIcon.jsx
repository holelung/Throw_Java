import { faLeaf } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

export const LeafIcon = ({size}) => {
  return (
    <FontAwesomeIcon icon={faLeaf} size={size} style={{ color: "#63E6BE"}} />
  );
}
