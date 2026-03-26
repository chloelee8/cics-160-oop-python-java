import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
from My_sprite import My_sprite
import pygame

class Colliding_object(My_sprite):
    def __init__(self, image_file_name: str, location: tuple[int, int] = (0, 0)):
        super().__init__(image_file_name, location)
        self.bounding = pygame.Rect(location[0], location[1], self.get_width(), self.get_height())

    def get_bounding_box(self) -> pygame.Rect:
        return self.bounding

    def is_colliding_with(self, co: 'Colliding_object') -> bool:
        return self.bounding.colliderect(co.get_bounding_box())